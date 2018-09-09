package io.github.mssjsg.formappkit.model.element

class InputField<T: InputField.Meta>(id: String, type: String, data: T): FormElement<T>(id, type, data) {
    class Meta(val isRequired: Boolean, val type: Class<out Any>)
}