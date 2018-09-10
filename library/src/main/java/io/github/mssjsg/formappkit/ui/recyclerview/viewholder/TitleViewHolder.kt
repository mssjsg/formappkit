package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.element.FieldTitle

class TitleViewHolder(view: View, form: Form): FormElementViewHolder<FieldTitle>(view, form, null) {
    private val textView: TextView

    init {
        textView = view as TextView
    }

    override fun bindElement(element: FieldTitle, form: Form, dataManager: FormDataManager?) {
        textView.setText(element.data)
    }

}