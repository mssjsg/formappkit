package io.github.mssjsg.formappkit.model

class FormConditionalElement(path: FormElementPath, title: String, val condition: String, val elements: List<FormElement>): FormElement(path, title)