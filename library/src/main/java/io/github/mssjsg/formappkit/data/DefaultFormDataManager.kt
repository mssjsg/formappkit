package io.github.mssjsg.formappkit.data

import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.Input
import io.github.mssjsg.formappkit.model.element.InputField
import kotlin.collections.HashMap

class DefaultFormDataManager : FormDataManager {
    private val forms: MutableMap<String, Form> = HashMap()

    private val dataMap: MutableMap<String, MutableMap<String, Any?>> = HashMap()

    override fun putForm(formId: String, form: Form) {
        if (forms.get(formId) == form) {
            return
        }
        forms.put(formId, form)
        dataMap.put(formId, HashMap())
    }

    override fun isFilled(formId: String): Boolean {
        // TODO
        return false
    }

    override fun isCompleted(formId: String): Boolean {
        // TODO
        return false
    }

    override fun <T> getInputData(formId: String, inputKey: String): T? {
        return dataMap.get(formId)?.get(inputKey) as T
    }

    override fun setInputData(formId: String, inputKey: String, data: Any) {
        dataMap.get(formId)?.put(inputKey, getInputDataType(formId, inputKey)?.cast(data))
    }

    override fun getInputDataType(formId: String, inputKey: String): Class<out Any>? {
        forms.get(formId)?.elements?.forEach {
            if (it is InputField) {
                it.inputs.filter { it.key == inputKey }.firstOrNull()
            }
        }
        return null
    }

    override fun getInputMap(formId: String): Map<String, Any?>? {
        return dataMap?.get(formId)
    }

    override fun getInputJson(formId: String): String {
        // TODO
        return ""
    }

}