package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import io.github.mssjsg.formappkit.R
import io.github.mssjsg.formappkit.model.FormEditText
import io.github.mssjsg.formappkit.ui.formitem.FormItem

class FormEditTextHolder(view: View): FormElementHolder(view) {
    private val inputView: TextInputLayout = view.findViewById(R.id.inputLayout)
    private val editText: EditText = view.findViewById(R.id.input)

    override fun bind(item: FormItem) {
        val element = item.getElement<FormEditText>()
        inputView.hint = element.placeHolder
        val data: String? = element.data
        editText.setText(data)
    }
}