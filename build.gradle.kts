buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
        //classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.2")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

ext {
    // moko_mvvm_version = "0.11.0"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}