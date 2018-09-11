package io.github.mssjsg.formappkit.model.element

import io.github.mssjsg.formappkit.model.Form

class SubForm(id: String, val meta: SubForm.Meta): FormElement<SubForm.Meta>(id, ELEMENT_TYPE_SUBFORM, meta) {
    class Meta(val title: String, val formId: String)
}