@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

android {
    namespace = "com.posse.kotlin1.calendar.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.posse.kotlin1.calendar.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }

        getByName("debug") {
            versionNameSuffix = ".debug"
        }
    }
}

dependencies {
    implementation(project(":common:umbrella-compose"))
    implementation(project(":common:global:core"))
    implementation(Dependencies.Android.Other.activity)
    implementation(Dependencies.Android.Other.materialTheme)
}