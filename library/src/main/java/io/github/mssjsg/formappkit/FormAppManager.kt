package io.github.mssjsg.formappkit

import android.support.v4.util.ArrayMap
import io.github.mssjsg.formappkit.model.FormSession

/**
 * A manager for helping to keep the data that may be used globally in the app. but it's not neccessary
 * to use this manager
 */
class FormAppManager {
    private var formSessions: MutableMap<String, FormSession> = ArrayMap()

    companion object {
        const val SESSION_ID_ANONYMOUS = "anonymous"
    }

    init {
        formSessions.put(SESSION_ID_ANONYMOUS, FormSession(SESSION_ID_ANONYMOUS))
    }

    fun addSession(formSession: FormSession) {
        formSessions.put(formSession.id, formSession)
    }

    fun getSession(sessionId: String): FormSession? {
        return formSessions.get(sessionId)
    }

    fun getAnonymousSession(): FormSession {
        return formSessions.get(SESSION_ID_ANONYMOUS)!!
    }

    fun removeSession(sessionId: String) {
        formSessions.remove(sessionId)
    }
}