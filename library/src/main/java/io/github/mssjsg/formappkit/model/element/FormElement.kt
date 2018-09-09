package io.github.mssjsg.formappkit.model.element

abstract class FormElement<T>(val type: String, var data: T) {
    companion object {
        const val ELEMENT_TYPE_SUBFORM = "TYPE_SUBFORM";
    }
}