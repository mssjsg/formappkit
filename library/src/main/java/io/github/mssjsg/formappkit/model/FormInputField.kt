package io.github.mssjsg.formappkit.model

abstract class FormInputField<DataType>(path: FormElementPath, title: String, var isRequired: Boolean,
                              var data: DataType? = null): FormElement(path, title)