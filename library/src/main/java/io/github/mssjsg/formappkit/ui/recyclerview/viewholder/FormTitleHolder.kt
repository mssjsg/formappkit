package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import io.github.mssjsg.formappkit.model.FormTitle
import io.github.mssjsg.formappkit.ui.formitem.FormItem

class FormTitleHolder(view: View): FormElementHolder(view) {
    private val textView: TextView = view as TextView

    override fun bind(item: FormItem) {
        textView.text = item.getElement<FormTitle>().title
    }
}