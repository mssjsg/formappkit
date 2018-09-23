package io.github.mssjsg.formappkit.ui.formitem

import io.github.mssjsg.formappkit.model.FormElement

class FormItem(val formElement: FormElement) {
    fun <Element: FormElement> getElement(): Element {
        return formElement as Element
    }
}