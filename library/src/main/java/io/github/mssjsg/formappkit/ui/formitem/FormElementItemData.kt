package io.github.mssjsg.formappkit.ui.formitem

import io.github.mssjsg.formappkit.model.element.FormElement

class FormElementItemData(val element: FormElement<out Any>): FormItemData(element.id)