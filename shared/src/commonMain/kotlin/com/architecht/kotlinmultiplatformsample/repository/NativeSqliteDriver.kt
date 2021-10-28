package com.architecht.kotlinmultiplatformsample.repository

import com.architecht.db.SampleDB
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
