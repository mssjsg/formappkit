package io.github.mssjsg.formappkit

import io.github.mssjsg.formappkit.data.DefaultFormDataManager
import io.github.mssjsg.formappkit.data.FormDataManager
import io.github.mssjsg.formappkit.model.Form

/**
 * A manager for helping to keep the data that may be used globally in the app. but it's not neccessary
 * to use this manager
 */
class FormAppManager {
    val formDataManager: FormDataManager = DefaultFormDataManager()
    val forms = hashMapOf<String, Form>()
}