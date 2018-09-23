package io.github.mssjsg.formappkit.model

import io.github.mssjsg.formappkit.ui.formitem.FormItem

class FormElementGroup(path: FormElementPath, title: String, val elements: MutableList<FormElement> = ArrayList()): FormElement(path, title) {
    fun toFormItems(): List<FormItem> {
        return elements.map { FormItem(it) }
    }

    fun importDataFromJson(json: String) {
        // TODO
    }

    fun exportDataToJson(): String {
        // TODO
        return ""
    }

    fun exportData(): Map<String, Any> {
        // TODO
        return HashMap()
    }

    override fun toString(): String {
        // TODO return json string
        return super.toString()
    }
}