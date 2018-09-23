package io.github.mssjsg.formappkit.ui.recyclerview

import android.support.v4.util.ArrayMap
import io.github.mssjsg.formappkit.model.FormElement
import kotlin.reflect.KClass

class ItemTypeIndexMap {
    private val indexMap: ArrayMap<KClass<out FormElement>, Int> = ArrayMap()

    fun getTypeIndex(formElement: FormElement): Int {
        if (!indexMap.containsKey(formElement::class)) {
            indexMap[formElement::class] = indexMap.size
        }
        return indexMap.get(formElement::class)!!
    }

    fun getClass(viewType: Int): Class<out FormElement>? {
        return indexMap.filter { it.value == viewType }.entries
                .firstOrNull()?.key?.java
    }
}