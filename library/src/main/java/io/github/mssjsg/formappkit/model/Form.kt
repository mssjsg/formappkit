package io.github.mssjsg.formappkit.model

import io.github.mssjsg.formappkit.model.element.FormElement

fun formOf(vararg elements: FormElement): Form {
    return Form(elements.toList())
}

data class Form(val elements: List<FormElement>)