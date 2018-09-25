package io.github.mssjsg.formappkit.model

data class FormElementPath(val ids: List<String>) {
    fun dropLast(i: Int): FormElementPath {
        return FormElementPath(ids.dropLast(i))
    }

    fun startWith(path: FormElementPath): Boolean {
        return ids.subList(0, path.ids.size) == path.ids
    }

    fun last(): String {
        return ids.last()
    }

    fun append(id: String): FormElementPath {
        return FormElementPath(ids.plus(id))
    }
}
