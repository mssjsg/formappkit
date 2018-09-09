package io.github.mssjsg.formappkit.model.element

abstract class InputField<T: InputField.Meta>(id: String, type: String, data: T): FormElement<T>(id, type, data) {
    open class Meta(val isRequired: Boolean, val type: Class<out Any>)
}