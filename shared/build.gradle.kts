import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
    kotlin("plugin.serialization")
}


object SqlDelight {
    const val runtime = "com.squareup.sqldelight:runtime:1.5.0"
    const val android = "com.squareup.sqldelight:android-driver:1.5.0"
    const val native = "com.squareup.sqldelight:native-driver:1.5.0"
}

object Ktor {
    const val ktor_version = "1.5.0"
    const val core = "io.ktor:ktor-client-core:$ktor_version"
    const val android = "io.ktor:ktor-client-android:${ktor_version}"
    const val ios = "io.ktor:ktor-client-ios:${ktor_version}"

    object Core {
        const val common = "io.ktor:ktor-client-core:${ktor_version}"
        const val jvm = "io.ktor:ktor-client-core-jvm:${ktor_version}"
        const val native = "io.ktor:ktor-client-core-native:${ktor_version}"
    }

    object Json {
        const val common = "io.ktor:ktor-client-json:${ktor_version}"
        const val jvm = "io.ktor:ktor-client-json-jvm:${ktor_version}"
        const val native = "io.ktor:ktor-client-json-native:${ktor_version}"
    }

    object Logging {
        const val common = "io.ktor:ktor-client-logging:${ktor_version}"
        const val jvm = "io.ktor:ktor-client-logging-jvm:${ktor_version}"
        const val slf4j = "org.slf4j:slf4j-simple:1.7.30"
        const val native = "io.ktor:ktor-client-logging-native:${ktor_version}"
    }

    object Serialization {
        const val common = "io.ktor:ktor-client-serialization:${ktor_version}"
        const val jvm = "io.ktor:ktor-client-serialization-jvm:${ktor_version}"
        const val native = "io.ktor:ktor-client-serialization-native:${ktor_version}"
    }
}
/*
object Coroutine {
    const val coroutine_version = "1.5.2-native-mt"
    const val runtime = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version"
}
*/

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // implementation("com.squareup.sqldelight:runtime:1.5.0")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation(SqlDelight.runtime)
                implementation(Ktor.core)
                implementation(Ktor.Core.common)
                implementation(Ktor.Json.common)
                implementation(Ktor.Serialization.common)
                // implementation("com.russhwolf:multiplatform-settings:0.8.1")
                // implementation("dev.icerock.moko:mvvm:0.11.0")
                // implementation(Coroutine.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(SqlDelight.android)
                implementation(Ktor.android)
                implementation(Ktor.Core.jvm)
                implementation(Ktor.Json.jvm)
                implementation(Ktor.Serialization.jvm)
                // implementation("androidx.lifecycle:lifecycle-extensions:0.11.0")
                // implementation(Coroutine.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(SqlDelight.native)
                implementation(Ktor.ios)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}

sqldelight {
    database("SampleDB") {
        packageName = "com.architecht.db"
        sourceFolders = listOf("sqldelight")
    }
}