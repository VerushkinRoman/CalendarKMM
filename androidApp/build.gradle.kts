@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.util.capitalizeDecapitalize.capitalizeAsciiOnly
import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("org.jetbrains.compose")
//    id("androidx.baselineprofile")
}

android {
    namespace = "com.posse.kotlin1.calendar"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.posse.kotlin1.calendar"
        minSdk = 26
        targetSdk = 34
        versionCode = 21
        versionName = "5.1.0"

        resourceConfigurations += "ru"
        ndk {
            abiFilters += setOf("armeabi-v7a","arm64-v8a","x86_64")
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Android.Other.composeCompiler
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/kotlin/**"
            excludes += "/META-INF/androidx.*.version"
            excludes += "/META-INF/com.google.*.version"
            excludes += "/META-INF/kotlinx_*.version"
            excludes += "/kotlin-tooling-metadata.json"
            excludes += "/DebugProbesKt.bin"
            excludes += "/META-INF/com/android/build/gradle/app-metadata.properties"
            excludes += "/*.properties"
            excludes += "/*.proto"
            excludes += "/junit/**"
            excludes += "/LICENSE-junit.txt"
        }
    }

    signingConfigs {
        create("release") {
            val properties = Properties().apply {
                load(File(projectDir, "signingKey.properties").reader())
            }

            storeFile = File(properties.getProperty("path_to_store_file"))
            storePassword = properties.getProperty("store_password")
            keyAlias = properties.getProperty("key_alias")
            keyPassword = properties.getProperty("key_password")
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "TYPE", "\"RELEASE\"")

            kotlinOptions {
                freeCompilerArgs += listOf(
                    "-Xno-call-assertions",
                    "-Xno-receiver-assertions",
                    "-Xno-param-assertions"
                )
            }
        }

        getByName("debug") {
            signingConfig = signingConfigs.getByName("release")
            versionNameSuffix = "-debug"
//            applicationIdSuffix = ".debug"
            buildConfigField("String", "TYPE", "\"DEBUG\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    kotlin {
        jvmToolchain(17)
    }

    applicationVariants.all {
        outputs.forEach { output ->
            val bundleFinalizeTaskName = StringBuilder("sign").run {
                productFlavors.forEach {
                    append(it.name.capitalizeAsciiOnly())
                }
                append(buildType.name.capitalizeAsciiOnly())
                append("Bundle")
                toString()
            }

            val outputName = buildString {
                append("app-")
                productFlavors.forEach {
                    append(it.name)
                    append("-")
                }
                append("v$versionName")
            }

            tasks.named(
                bundleFinalizeTaskName,
                com.android.build.gradle.internal.tasks.FinalizeBundleTask::class.java
            ) {
                val file = finalBundleFile.asFile.get()
                val finalFile = File(file.parentFile, "$outputName.aab")
                finalBundleFile.set(finalFile)
            }
            if (output is com.android.build.gradle.internal.api.BaseVariantOutputImpl) {
                output.outputFileName = "$outputName.${output.outputFile.extension}"
            }
        }
    }
}

dependencies {
    implementation(project(":common:umbrella-compose"))

    implementation(Dependencies.Android.Other.materialTheme)

    implementation(platform(Dependencies.Android.Crashlytics.platform))
    implementation(Dependencies.Android.Crashlytics.crashlytics)
    implementation(Dependencies.Android.Crashlytics.analytics)
    implementation(Dependencies.Android.Messaging.gms)
    implementation("androidx.profileinstaller:profileinstaller:1.3.1")
//    "baselineProfile"(project(":androidApp:baselineprofile"))

    debugImplementation(Dependencies.Android.Other.leakcanary)
}