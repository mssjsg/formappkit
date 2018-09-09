package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Form

class SubForm(val id: String, val title: String, form: Form): FormElement<Form>(ELEMENT_TYPE_SUBFORM, form)