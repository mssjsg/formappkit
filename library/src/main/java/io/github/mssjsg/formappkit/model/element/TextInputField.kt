package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Input

class TextInputField(id: String, isRequired: Boolean, val hint: String, val inputKey: String): InputField(id,
        ELEMENT_TYPE_TEXT_FIELD, isRequired,
        arrayOf(Input(inputKey, String::class.java)))