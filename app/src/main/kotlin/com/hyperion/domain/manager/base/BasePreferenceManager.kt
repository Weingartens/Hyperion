package com.hyperion.domain.manager.base

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private typealias Getter<T> = (key: String, defaultValue: T) -> T
private typealias Setter<T> = (key: String, value: T) -> Unit

abstract class BasePreferenceManager(private val prefs: SharedPreferences) {
    protected fun getString(key: String, defaultValue: String) =
        prefs.getString(key, defaultValue) ?: defaultValue

    private fun getBoolean(key: String, defaultValue: Boolean) = prefs.getBoolean(key, defaultValue)
    private fun getInt(key: String, defaultValue: Int) = prefs.getInt(key, defaultValue)
    private fun getFloat(key: String, defaultValue: Float) = prefs.getFloat(key, defaultValue)
    protected inline fun <reified E : Enum<E>> getEnum(key: String, defaultValue: E) =
        enumValueOf<E>(getString(key, defaultValue.name))

    protected fun putString(key: String, value: String?) = prefs.edit { putString(key, value) }
    private fun putBoolean(key: String, value: Boolean) = prefs.edit { putBoolean(key, value) }
    private fun putInt(key: String, value: Int) = prefs.edit { putInt(key, value) }
    private fun putFloat(key: String, value: Float) = prefs.edit { putFloat(key, value) }
    protected inline fun <reified E : Enum<E>> putEnum(key: String, value: E) =
        putString(key, value.name)

    protected class Preference<T : Any>(
        private val key: String,
        defaultValue: T,
        getter: Getter<T>,
        private val setter: Setter<T>
    ) : ReadWriteProperty<Any, T> {
        private var value by mutableStateOf(getter(key, defaultValue))

        override operator fun getValue(thisRef: Any, property: KProperty<*>) = value
        override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            this.value = value
            setter(key, value)
        }
    }

    protected fun preference(key: String, defaultValue: String = "") = Preference(
        key = key,
        defaultValue = defaultValue,
        getter = ::getString,
        setter = ::putString
    )

    protected fun preference(key: String, defaultValue: Boolean) = Preference(
        key = key,
        defaultValue = defaultValue,
        getter = ::getBoolean,
        setter = ::putBoolean
    )

    protected fun preference(key: String, defaultValue: Int) = Preference(
        key = key,
        defaultValue = defaultValue,
        getter = ::getInt,
        setter = ::putInt
    )

    protected fun preference(key: String, defaultValue: Float) = Preference(
        key = key,
        defaultValue = defaultValue,
        getter = ::getFloat,
        setter = ::putFloat
    )

    protected inline fun <reified E : Enum<E>> preference(
        key: String,
        defaultValue: E
    ) = Preference(
        key = key,
        defaultValue = defaultValue,
        getter = ::getEnum,
        setter = ::putEnum
    )
}