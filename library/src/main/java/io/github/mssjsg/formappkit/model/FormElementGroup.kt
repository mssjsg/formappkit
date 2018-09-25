package io.github.mssjsg.formappkit.model

import android.support.v4.util.ArrayMap
import io.github.mssjsg.formappkit.ui.formitem.FormItem

class FormElementGroup(path: FormElementPath, title: String, val elements: MutableList<FormElement> = ArrayList(),
                       isRequired: Boolean = true): FormInputElement<Map<String, Any>>(path, title, isRequired) {

    override var data: Map<String, Any>?
        get() {
            return ArrayMap<String, Any>().apply {
                elements.forEach { element ->
                    if (element is FormInputElement<*>) {
                        element.data?.let { data -> put(element.path.last(), data) }
                    }
                }
            }
        }

        set(map) {
            elements.forEach { element ->
                map?.let { map ->
                    if (element is FormInputElement<*>) {
                        map[element.path.last()]?.let { input ->
                            element.trySetData(input)
                        }
                    }
                }
            }
        }

    override fun cast(input: Any): Map<String, Any>? {
        return input as Map<String, Any>
    }

    fun <T: FormElement> getElement(path: FormElementPath): T? {
        return elements.filter { it.path == path }.firstOrNull() as T?
    }

    fun toFormItems(): List<FormItem> {
        return elements.map { FormItem(it) }
    }

    override fun toString(): String {
        // TODO return json string
        return super.toString()
    }
}