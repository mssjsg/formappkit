package io.github.mssjsg.formappkit.ui.formitem

import io.github.mssjsg.formappkit.model.Form

class FormItemsManager {
    val itemListeners: MutableList<ItemListener> = ArrayList()

    private val formItems: MutableList<FormItem> = ArrayList()

    fun addForm(form: Form) {
        form.elements.forEach {
            val formData = FormElementItemData(it)
            formItems.add(FormItem(formData))
        }
    }

    fun addItem(formItem: FormItem) {
        formItems.add(formItem)
        itemListeners.forEach {
            it.onItemAdded(formItems.size - 1, formItem)
        }
    }

    fun removeItem(formItem: FormItem) {
        val index = formItems.indexOf(formItem)
        formItems.remove(formItem)
        itemListeners.forEach {
            it.onItemRemoved(index, formItem)
        }
    }

    fun setItemVisible(id: String, visible: Boolean) {
        formItems.filter {
            it.data.id == id
        }.forEach { item ->
            item.isVisible = visible
            val index = formItems.indexOf(item)
            itemListeners.forEach {
                it.onItemChanged(index, item)
            }
        }
    }

    interface ItemListener {
        fun onItemRemoved(position: Int, formItem: FormItem)

        fun onItemAdded(position: Int, formItem: FormItem)

        fun onItemChanged(position: Int, formItem: FormItem)
    }
}