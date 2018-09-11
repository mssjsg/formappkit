package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.element.InputField
import io.github.mssjsg.formappkit.ui.formitem.FormElementItemData

abstract class InputViewHolder<Data: InputField<out InputField.Meta>>(view: View, val formId: String,
                                                                      val formDataManager: FormDataManager): FormElementViewHolder<Data>(view) {
    override fun bindData(data: FormElementItemData) {
        super.bindData(data)
        bindInputData(formId, data.id, formDataManager)
    }

    abstract fun bindInputData(formId: String, fieldId: String,
                               formDataManager: FormDataManager)
}