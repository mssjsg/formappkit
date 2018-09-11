package io.github.mssjsg.formappkit

object FormAppKit {
    private val formAppManager: FormAppManager = FormAppManager()
    private val managers: MutableMap<String, FormAppManager> = HashMap()

    fun getDefaultFormAppManager(): FormAppManager {
        return formAppManager
    }

    fun getFormAppManager(managerId: String): FormAppManager {
        if (!managers.containsKey(managerId)) {
            managers.put(managerId, FormAppManager())
        }

        return managers.get(managerId)!!;
    }
}