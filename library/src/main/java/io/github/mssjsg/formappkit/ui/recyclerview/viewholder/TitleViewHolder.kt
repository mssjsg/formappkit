package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.element.Title

class TitleViewHolder(view: View): FormElementViewHolder<Title>(view) {
    private val textView: TextView

    init {
        textView = view as TextView
    }

    override fun bindElement(element: Title) {
        textView.setText(element.data)
    }

}