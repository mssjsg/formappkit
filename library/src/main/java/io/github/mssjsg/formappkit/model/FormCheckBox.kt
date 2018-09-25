package io.github.mssjsg.formappkit.model

class FormCheckBox(path: FormElementPath, title: String, isRequired: Boolean = true): FormInputElement<Boolean>(path, title, isRequired) {
    override fun cast(input: Any): Boolean? {
        return when(input) {
            is Boolean -> input
            else -> null
        }
    }
}