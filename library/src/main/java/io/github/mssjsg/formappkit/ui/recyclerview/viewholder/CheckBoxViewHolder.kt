package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import android.widget.CheckBox
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.element.CheckBoxField

class CheckBoxViewHolder(view: View, formId: String, dataManager: FormDataManager): InputViewHolder<CheckBoxField>(view, formId, dataManager) {
    private val checkBox: CheckBox

    init {
        checkBox = view.findViewById(R.id.checkbox)
    }

    override fun bindElement(element: CheckBoxField) {
        checkBox.setText(element.data.title)
    }

    override fun bindInputData(formId: String, fieldId: String, formDataManager: FormDataManager) {
        val data: Boolean? = formDataManager.getInputData<Boolean>(formId, fieldId)
        checkBox.isChecked = data ?: false
    }
}