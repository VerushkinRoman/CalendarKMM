@file:Suppress("ConstPropertyName", "SpellCheckingInspection")

object Dependencies {

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.21.2"
    }

    object Kotlin {
        private const val version = "1.9.23"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3"
        }

        object Coroutines {
            private const val version = "1.8.1"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.6.11"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Navigation {
        private const val jetbrainsVersion = "2.7.0-alpha07"
        const val jetbrainsNavigation = "org.jetbrains.androidx.navigation:navigation-compose:$jetbrainsVersion"
    }

    object ViewModel {
        private const val version = "2.8.0"
        const val core = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel:$version"
        const val compose = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:$version"
    }

    object Ktor {
        private const val version = "2.3.10"
        const val core = "io.ktor:ktor-client-core:$version"
        const val cio = "io.ktor:ktor-client-cio:$version"
        const val ios = "io.ktor:ktor-client-darwin:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:8.2.2"
        const val gradleGoogleServicesPlugin = "com.google.gms:google-services:4.4.1"
        const val gradleGoogleCrashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:2.9.9"
        const val baselineProfileGradlePlugin = "androidx.benchmark:benchmark-baseline-profile-gradle-plugin:1.2.3"

        object Crashlytics {
            private const val version = "32.8.1"
            const val platform = "com.google.firebase:firebase-bom:$version"
            const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
            const val analytics = "com.google.firebase:firebase-analytics-ktx"
        }

        object Messaging {
            const val gms = "com.google.firebase:firebase-messaging-ktx"
            const val hms = "com.huawei.hms:push:6.11.0.300"
        }

        object BaselineProfile {
            const val junit = "androidx.test.ext:junit:1.1.5"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
            const val uiautomator = "androidx.test.uiautomator:uiautomator:2.3.0"
            const val benchmarkMacroJunit4 = "androidx.benchmark:benchmark-macro-junit4:1.2.3"
        }

        object Other {
            const val core = "androidx.core:core-ktx:1.13.0"
            const val materialTheme = "com.google.android.material:material:1.11.0"
            const val security = "androidx.security:security-crypto-ktx:1.1.0-alpha06"
//            const val playAuthPhone = "com.google.android.gms:play-services-auth-api-phone:18.0.2"
            const val playAuth = "com.google.android.gms:play-services-auth:21.1.0"
//            const val hmsAuth = "com.huawei.hms:hwid:6.12.0.300"
            const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.14"
            const val composeLifecycle = "androidx.lifecycle:lifecycle-runtime-compose:2.7.0"
            const val activityCompose = "androidx.activity:activity-compose:1.9.0"
            const val composeCompiler = "1.5.14"
        }
    }

    object Resources {
        private const val version = "0.24.1"
        const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
        const val core = "dev.icerock.moko:resources:$version"
        const val compose = "dev.icerock.moko:resources-compose:$version"
        const val graphics = "dev.icerock.moko:graphics:0.9.0"
    }

    object Firebase {
        private const val version = "1.13.0"
        const val firestore = "dev.gitlive:firebase-firestore:$version"
        const val auth = "dev.gitlive:firebase-auth:$version"
    }

//    object Permissions {
//        private const val version = "0.16.0"
//        const val core = "dev.icerock.moko:permissions:$version"
//        const val compose = "dev.icerock.moko:permissions-compose:$version"
//    }

    object Settings {
        private const val version = "1.1.1"
        const val core = "com.russhwolf:multiplatform-settings:$version"
        const val serialization = "com.russhwolf:multiplatform-settings-serialization:$version"
    }

    object Other {
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.6.0"
        const val immutableCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7"
        //        const val completeKotlinGradlePlugin = "com.louiscad.complete-kotlin:plugin:1.1.0"
        const val windowSizeClass = "dev.chrisbanes.material3:material3-window-size-class-multiplatform:0.5.0"
        const val windowInsets = "com.moriatsushi.insetsx:insetsx:0.1.0-alpha10"
    }
}