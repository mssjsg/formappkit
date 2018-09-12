package io.github.mssjsg.formappkit.data

import io.github.mssjsg.formappkit.model.Form
import io.github.mssjsg.formappkit.model.Input

interface FormDataManager {
    /**
     * put a form with an Id
     * @param formId form id
     * @param form form
     */
    fun putForm(formId: String, form: Form)

    /**
     * @param formId form Id
     * @return true if any fields are filled
     */
    fun isFilled(formId: String): Boolean

    /**
     * @param formId form Id
     * @return true if all required fields are filled
     */
    fun isCompleted(formId: String): Boolean

    /**
     * @param formId form Id
     * @param inputKey input key
     * @return input data
     */
    fun <T> getInputData(formId: String, inputKey: String): T?

    /**
     * @param formId form Id
     * @param fieldId field Id
     * @param data data
     */
    fun setInputData(formId: String, fieldId: String, data: Any)

    /**
     * @return input data class type
     */
    fun getInputDataType(formId: String, inputKey: String): Class<out Any>?

    /**
     * @return get input map
     */
    fun getInputMap(formId: String): Map<String, Any?>?

    /**
     * @return get input json
     */
    fun getInputJson(formId: String): String
}