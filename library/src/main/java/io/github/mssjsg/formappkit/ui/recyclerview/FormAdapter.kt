package io.github.mssjsg.formappkit.ui.recyclerview

import android.support.v4.util.ArrayMap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.element.FormElement
import io.github.mssjsg.formappkit.model.element.TextInputField
import io.github.mssjsg.formappkit.ui.formitem.FormElementItemData
import io.github.mssjsg.formappkit.ui.formitem.FormItem
import io.github.mssjsg.formappkit.ui.formitem.FormItemData
import io.github.mssjsg.formappkit.ui.formitem.FormItemsManager
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.*

class FormAdapter(val formDataManager: FormDataManager, val formId: String,
                  val form: Form): RecyclerView.Adapter<FormItemViewHolder<out FormItemData>>(), FormItemsManager.ItemListener {
    private val formItemsManager = FormItemsManager()

    private val itemTypes: ArrayMap<String, Int> = ArrayMap()

    init {
        formItemsManager.itemListeners.add(this)
        itemTypes.put(FormElement.ELEMENT_TYPE_TITLE, itemTypes.size)
        itemTypes.put(FormElement.ELEMENT_TYPE_TEXT_FIELD, itemTypes.size)
        itemTypes.put(FormElement.ELEMENT_TYPE_SUBFORM, itemTypes.size)

        formItemsManager.addForm(form)
    }

    fun addType(type: String) {
        itemTypes.put(type, itemTypes.size)
    }

    override fun onItemRemoved(position: Int, formItem: FormItem) {
        notifyItemRemoved(position)
    }

    override fun onItemAdded(position: Int, formItem: FormItem) {
        notifyItemInserted(position)
    }

    override fun onItemChanged(position: Int, formItem: FormItem) {
        notifyItemChanged(position)
    }

    override fun getItemViewType(position: Int): Int {
        val unknownType = itemTypes.size
        val pageItem = formItemsManager.getItem(position)
        when(pageItem.data) {
            is FormElementItemData -> {
                val type = itemTypes.get(pageItem.data.element.type)
                return type ?: unknownType
            }
        }

        return unknownType
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FormItemViewHolder<out FormItemData> {
        val pageItem = formItemsManager.getItem(position)
        val layoutInflater = LayoutInflater.from(parent.context)
        when(pageItem.data) {
            is FormElementItemData -> {
                return createFormElementViewHolder(layoutInflater, parent, pageItem.data)
            }
        }

        return UnknownItemViewHolder(layoutInflater.inflate(R.layout.item_title, parent, false))
    }

    private fun createFormElementViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup,
                                            formElementData: FormElementItemData): FormItemViewHolder<out FormItemData> {
        when(formElementData.element.type) {
            FormElement.ELEMENT_TYPE_TITLE -> {
                return TitleViewHolder(layoutInflater.inflate(R.layout.item_title, parent, false))
            }
            FormElement.ELEMENT_TYPE_TEXT_FIELD -> {
                return TextInputViewHolder(layoutInflater.inflate(R.layout.item_text_field, parent, false),
                        formId, formDataManager)
            }
            FormElement.ELEMENT_TYPE_CHECK_BOX -> {
                return CheckBoxViewHolder(layoutInflater.inflate(R.layout.item_check_box, parent, false),
                        formId, formDataManager)
            }
            FormElement.ELEMENT_TYPE_SUBFORM -> {
                // TODO
            }
        }

        return UnknownItemViewHolder(layoutInflater.inflate(R.layout.item_title, parent, false))
    }

    override fun getItemCount(): Int {
        return formItemsManager.getItemsCount()
    }

    override fun onBindViewHolder(formItemViewHolder: FormItemViewHolder<out FormItemData>, position: Int) {
        when(formItemViewHolder) {
            is FormElementViewHolder<out FormElement> -> {
                formItemViewHolder.bindData(formItemsManager.getItem(position).data as FormElementItemData)
            }
        }
    }
}