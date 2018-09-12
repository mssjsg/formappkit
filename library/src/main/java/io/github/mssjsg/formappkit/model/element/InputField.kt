package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Input

abstract class InputField(id: String, type: String, val isRequired: Boolean,
                             val inputs: Array<Input>): FormElement(id, type)