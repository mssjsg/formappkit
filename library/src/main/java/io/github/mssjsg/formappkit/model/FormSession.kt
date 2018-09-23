package io.github.mssjsg.formappkit.model

class FormSession(val id: String,
                  var formElementGroup: FormElementGroup? = null) {

    fun isFilled(path: FormElementPath): Boolean {
        // TODO
        return false
    }

    fun isCompleted(formElementPath: FormElementPath): Boolean {
        // TODO
        return false
    }
}