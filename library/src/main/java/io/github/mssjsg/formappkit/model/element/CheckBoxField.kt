package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Input

class CheckBoxField(id: String, isRequired: Boolean, val title: String, val inputKey: String): InputField(id,
        ELEMENT_TYPE_CHECK_BOX, isRequired,
        arrayOf(Input(inputKey, Boolean::class.java)))