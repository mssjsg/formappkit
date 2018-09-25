package io.github.mssjsg.formappkit.model

abstract class FormInputElement<DataType>(path: FormElementPath, title: String, var isRequired: Boolean = true,
                                          open var data: DataType? = null): FormElement(path, title) {
    fun trySetData(input: Any) {
        cast(input)?.let { data = it }
    }

    abstract fun cast(input: Any): DataType?
}