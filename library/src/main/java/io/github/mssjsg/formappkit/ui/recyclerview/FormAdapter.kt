package io.github.mssjsg.formappkit.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.github.mssjsg.formappkit.model.FormElement
import io.github.mssjsg.formappkit.ui.formitem.FormItem
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.FormElementHolder
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.UnknownItemViewHolder

abstract class FormAdapter: RecyclerView.Adapter<FormElementHolder>() {
    private val formItems: MutableList<FormItem> = ArrayList()

    private val itemTypeMap: ItemTypeIndexMap = ItemTypeIndexMap()

    fun addFormItems(items: List<FormItem>) {
        formItems.addAll(items)
        notifyItemRangeInserted(itemCount, items.size)
    }

    fun clear() {
        formItems.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): FormItem {
        return formItems[position]
    }

    fun addItem(formItem: FormItem) {
        formItems.add(formItem)
        notifyItemInserted(formItems.size - 1)
    }

    fun removeItem(formItem: FormItem) {
        val index = formItems.indexOf(formItem)
        formItems.remove(formItem)
        notifyItemRemoved(index)
    }

    override fun getItemViewType(position: Int): Int {
        return itemTypeMap.getTypeIndex(getItem(position).formElement)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormElementHolder {
        return itemTypeMap.getClass(viewType)?.let {
            onCreateViewHolder(parent, it)
        } ?: UnknownItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return formItems.size
    }

    override fun onBindViewHolder(holder: FormElementHolder, position: Int) {
        holder.bind(getItem(position))
    }

    abstract fun onCreateViewHolder(parent: ViewGroup, elementClass: Class<out FormElement>): FormElementHolder?
}