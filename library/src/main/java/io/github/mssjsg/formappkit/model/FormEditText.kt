package io.github.mssjsg.formappkit.model

class FormEditText(path: FormElementPath, title: String, var placeHolder: String = title,
                   isRequired: Boolean = true): FormInputElement<String>(path, title, isRequired) {
    override fun cast(input: Any): String? {
        return when(input) {
            is String -> input
            else -> ""
        }
    }
}