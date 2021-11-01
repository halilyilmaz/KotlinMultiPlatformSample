package com.architecht.kotlinmultiplatformsample.storage

import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

actual class KeyValueStorageFactory {
    actual fun createDriver(): Settings {
        val delegate = NSUserDefaults.standardUserDefaults
        val settings = AppleSettings(delegate)
        return settings
    }
}
