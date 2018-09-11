package io.github.mssjsg.formappkit.model.element

class TextInputField(id: String, meta: Meta): InputField<TextInputField.Meta>(id,
        ELEMENT_TYPE_TEXT_FIELD, meta) {
    class Meta(isRequired: Boolean,
               val hint: String): InputField.Meta(isRequired, String.javaClass)
}