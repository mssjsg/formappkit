package io.github.mssjsg.formappkit.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.model.FormCheckBox
import io.github.mssjsg.formappkit.model.FormEditText
import io.github.mssjsg.formappkit.model.FormElement
import io.github.mssjsg.formappkit.model.FormTitle
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.FormCheckBoxHolder
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.FormEditTextHolder
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.FormElementHolder
import io.github.mssjsg.formappkit.ui.recyclerview.viewholder.FormTitleHolder

class SimpleFormAdapter: FormAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, elementClass: Class<out FormElement>): FormElementHolder? {
        return inflateView(parent, elementClass)?.let { createViewHolder(elementClass, it) }
    }

    private fun inflateView(parent: ViewGroup, elementClass: Class<out FormElement>): View? {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(elementClass) {
            FormTitle::class.java -> R.layout.item_title
            FormEditText::class.java -> R.layout.item_edit_text
            FormCheckBox::class.java -> R.layout.item_check_box
            else -> null
        }?.let { layoutInflater.inflate(it, parent, false) }
    }

    private fun createViewHolder(elementClass: Class<out FormElement>, view: View): FormElementHolder? {
        return when(elementClass) {
            FormTitle::class.java -> FormTitleHolder(view)
            FormEditText::class.java -> FormEditTextHolder(view)
            FormCheckBox::class.java -> FormCheckBoxHolder(view)
            else -> null
        }
    }
}