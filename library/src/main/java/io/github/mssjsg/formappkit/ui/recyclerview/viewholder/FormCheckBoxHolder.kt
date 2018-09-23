package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.CheckBox
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.model.FormCheckBox
import io.github.mssjsg.formappkit.ui.formitem.FormItem

class FormCheckBoxHolder(view: View): FormElementHolder(view) {
    private val checkBox: CheckBox = view.findViewById(R.id.checkbox)

    override fun bind(item: FormItem) {
        val element = item.getElement<FormCheckBox>()
        checkBox.text = element.title
        val data: Boolean? = element.data
        checkBox.isChecked = data ?: false
    }
}