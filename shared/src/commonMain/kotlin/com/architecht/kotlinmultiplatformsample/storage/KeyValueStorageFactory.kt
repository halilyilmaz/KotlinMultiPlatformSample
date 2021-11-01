package com.architecht.kotlinmultiplatformsample.storage

import com.russhwolf.settings.Settings

expect class KeyValueStorageFactory {
    fun createDriver(): Settings
}