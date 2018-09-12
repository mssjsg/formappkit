package io.github.mssjsg.formappkit.model.element

fun textInputField(id: String, isRequired: Boolean, hint: String): TextInputField {
    return TextInputField(id, TextInputField.Meta(isRequired, hint))
}

class TextInputField(id: String, meta: Meta): InputField<TextInputField.Meta>(id,
        ELEMENT_TYPE_TEXT_FIELD, meta) {

    class Meta(isRequired: Boolean,
               val hint: String): InputField.Meta(isRequired, String.javaClass)
}