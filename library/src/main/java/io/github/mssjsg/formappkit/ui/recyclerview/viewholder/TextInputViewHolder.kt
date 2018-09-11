package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.element.TextInputField

class TextInputViewHolder(view: View, formId: String, dataManager: FormDataManager): InputViewHolder<TextInputField>(view, formId, dataManager) {
    private val inputView: TextInputLayout
    private val editText: EditText

    init {
        inputView = view.findViewById(R.id.inputLayout)
        editText = view.findViewById(R.id.input)

    }

    override fun bindElement(element: TextInputField) {
        inputView.setHint(element.data.hint)
    }

    override fun bindInputData(formId: String, fieldId: String, formDataManager: FormDataManager) {
        val data: String? = formDataManager.getInputData<String>(formId, fieldId)
        editText.setText(data)
    }
}