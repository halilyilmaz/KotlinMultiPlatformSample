package com.architecht.kotlinmultiplatformsample.repository

import com.architecht.db.SampleDB
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SampleDB.Schema, "members.db")
    }
}