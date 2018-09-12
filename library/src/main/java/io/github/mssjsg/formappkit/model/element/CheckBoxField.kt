package io.github.mssjsg.formappkit.model.element

fun checkBoxField(id: String, isRequired: Boolean, title: String): CheckBoxField {
    return CheckBoxField(id, CheckBoxField.Meta(isRequired, title))
}

class CheckBoxField(id: String, meta: CheckBoxField.Meta): InputField<CheckBoxField.Meta>(id, ELEMENT_TYPE_CHECK_BOX, meta) {
    class Meta(isRequired: Boolean, val title: String): InputField.Meta(isRequired, Boolean::class.java)
}