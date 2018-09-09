package io.github.mssjsg.formappkit.data

import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.InputData
import kotlin.collections.HashMap

class DefaultFormDataManager : FormDataManager {
    private val forms: MutableMap<String, Form> = HashMap()

    private val dataMap: MutableMap<String, MutableMap<String, InputData>> = HashMap()

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

    override fun <T> getInputData(formId: String, fieldId: String): T? {
        return dataMap.get(formId)?.get(fieldId)?.data as T
    }

    override fun setInputData(formId: String, fieldId: String, data: Any) {
        val inputData = dataMap.get(formId)?.get(fieldId)
        inputData?.apply {
            this.data = clazz.cast(data)
        }
    }

    override fun getInputDataType(fieldId: String): Class<out Any> {
        return String::class.java
    }

    override fun getInputMap(formId: String): Map<String, InputData>? {
        return dataMap?.get(formId)
    }

    override fun getInputJson(formId: String): String {
        // TODO
        return ""
    }

}