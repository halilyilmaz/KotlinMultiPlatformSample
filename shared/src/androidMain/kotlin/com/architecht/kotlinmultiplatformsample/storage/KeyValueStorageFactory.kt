package com.architecht.kotlinmultiplatformsample.storage

import android.content.Context
import android.preference.PreferenceManager
import com.russhwolf.settings.AndroidSettings
import com.russhwolf.settings.Settings

actual class KeyValueStorageFactory(private val context: Context) {
    actual fun createDriver(): Settings {
        val delegate = PreferenceManager.getDefaultSharedPreferences(context)
        val settings: Settings = AndroidSettings(delegate)
        return settings
    }
}