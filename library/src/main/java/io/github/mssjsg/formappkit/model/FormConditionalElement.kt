package io.github.mssjsg.formappkit.model

import io.github.mssjsg.formappkit.model.condition.FormCondition

class FormConditionalElement(path: FormElementPath, title: String, val condition: FormCondition, val elements: List<FormElement>): FormElement(path, title)