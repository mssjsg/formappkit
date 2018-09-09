package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Form

class SubForm(id: String, val title: String, form: Form): FormElement<Form>(id, ELEMENT_TYPE_SUBFORM, form)