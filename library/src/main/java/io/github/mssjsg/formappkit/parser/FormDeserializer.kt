package io.github.mssjsg.formappkit.parser

interface FormDeserializer<Source> {
    fun deserialize(source: Source): Map<String, Any>
}