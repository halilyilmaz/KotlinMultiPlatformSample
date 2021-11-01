package com.architecht.kotlinmultiplatformsample.model

data class GenericBaseModel<out T>(
    val data: T? = null,
    val exception: String? = null,
    val empty: Boolean = false,
    val loading: Boolean = false
)