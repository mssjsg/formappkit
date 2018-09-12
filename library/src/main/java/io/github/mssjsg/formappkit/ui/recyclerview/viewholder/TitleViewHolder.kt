package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import io.github.mssjsg.formappkit.model.element.TitleLabel

class TitleViewHolder(view: View): FormElementViewHolder<TitleLabel>(view) {
    private val textView: TextView

    init {
        textView = view as TextView
    }

    override fun bindElement(element: TitleLabel) {
        textView.setText(element.title)
    }

}