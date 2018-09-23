package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.mssjsg.formappkit.ui.formitem.FormItem

abstract class FormElementHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(item: FormItem)
}