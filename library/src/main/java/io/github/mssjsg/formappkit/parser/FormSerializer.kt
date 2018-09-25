package io.github.mssjsg.formappkit.parser

interface FormSerializer<Output> {
    fun serialize(source: Map<String, Any>): Output
}