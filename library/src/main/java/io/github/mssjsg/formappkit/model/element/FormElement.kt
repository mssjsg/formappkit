package io.github.mssjsg.formappkit.model.element

abstract class FormElement<T>(val id: String, val type: String, var data: T) {
    companion object {
        const val ELEMENT_TYPE_TITLE = "TYPE_TITLE";
        const val ELEMENT_TYPE_TEXT_FIELD = "TYPE_TEXT_FIELD";
        const val ELEMENT_TYPE_CHECK_BOX = "TYPE_CHECK_BOX";
        const val ELEMENT_TYPE_SUBFORM = "TYPE_SUBFORM";
    }
}