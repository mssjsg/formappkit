package io.github.mssjsg.formappkit.model

fun dataPathOf(key: String): FormElementPath {
    val paths = key.split(".")
    return FormElementPath(paths)
}
