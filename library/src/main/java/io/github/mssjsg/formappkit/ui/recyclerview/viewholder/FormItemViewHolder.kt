package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.mssjsg.formappkit.ui.formitem.FormItemData

abstract class FormItemViewHolder<Data: FormItemData>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bindData(data: Data)
}