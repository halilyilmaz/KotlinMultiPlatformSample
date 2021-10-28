pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KotlinMultiPlatformSample"
include(":androidApp")
include(":shared")