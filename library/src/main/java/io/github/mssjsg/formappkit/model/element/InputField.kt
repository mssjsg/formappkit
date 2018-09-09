package io.github.mssjsg.formappkit.model.element

class InputField<T: InputField.Meta>(val id: String, type: String, data: T): FormElement<T>(type, data) {
    class Meta(val isRequired: Boolean, val type: Class<out Any>)
}