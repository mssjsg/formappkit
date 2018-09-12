package io.github.mssjsg.formappkit.model

fun formListOf(form: Form): FormList {
    return FormList(form)
}

data class FormList(val form: Form)