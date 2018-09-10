package io.github.mssjsg.formappkit.model

import io.github.mssjsg.formappkit.model.element.FormElement

fun formOf(vararg elements: FormElement<out Any>): Form {
    return Form(elements.toList())
}

class Form(val elements: List<FormElement<out Any>>)