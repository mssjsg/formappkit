package io.github.mssjsg.formappkit.model

class FormEditText(path: FormElementPath, title: String, var placeHolder: String = title,
                   isRequired: Boolean = true): FormInputField<String>(path, title, isRequired)