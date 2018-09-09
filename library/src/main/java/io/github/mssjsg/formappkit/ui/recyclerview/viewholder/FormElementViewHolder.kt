package io.github.mssjsg.formappkit.ui.recyclerview.viewholder

import android.view.View
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.element.FormElement
import io.github.mssjsg.formappkit.ui.formitem.FormElementItemData

abstract class FormElementViewHolder<Element: FormElement<out Any>>(view: View, val formDataManager: FormDataManager?):
        FormItemViewHolder<FormElementItemData>(view) {
    override fun bindData(data: FormElementItemData) {
        bindElement(data.element as Element, formDataManager)
    }

    abstract fun bindElement(element: Element, dataManager: FormDataManager?)
}