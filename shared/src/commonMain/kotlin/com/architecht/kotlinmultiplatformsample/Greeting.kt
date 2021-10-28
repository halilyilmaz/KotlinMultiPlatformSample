package com.architecht.kotlinmultiplatformsample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}