package io.github.mssjsg.formappkit.model.element

fun titleLabel(title: String): TitleLabel {
    return TitleLabel(title)
}

class TitleLabel(title: String): FormElement<String>("", ELEMENT_TYPE_TITLE, title)