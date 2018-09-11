package io.github.mssjsg.formappkit.model.element

class CheckBox(id: String, meta: CheckBox.Meta): InputField<CheckBox.Meta>(id, ELEMENT_TYPE_CHECK_BOX, meta) {
    class Meta(isRequired: Boolean, title: String): InputField.Meta(isRequired, Boolean::class.java)
}