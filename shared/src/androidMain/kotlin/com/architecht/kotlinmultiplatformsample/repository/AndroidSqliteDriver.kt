package com.architecht.kotlinmultiplatformsample.repository

import android.content.Context
import com.architecht.db.SampleDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SampleDB.Schema, context, "members.db")
    }
}