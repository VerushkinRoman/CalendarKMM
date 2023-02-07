object Dependencies {

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.18.0"
    }

    object Kotlin {
        private const val version = "1.8.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.8.0"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0-RC"
        }

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.3.0"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.3.1"

        object Google {
            const val auth = "com.google.android.gms:play-services-auth:20.4.0"
        }

        object Other {
            const val activity = "androidx.activity:activity-compose:1.6.1"
            const val core = "androidx.core:core-ktx:1.9.0"
            const val materialTheme = "com.google.android.material:material:1.7.0"
        }
    }

    object ViewModel {
        private const val version = "0.13"
        const val core = "com.adeo:kviewmodel:$version"
        const val compose = "com.adeo:kviewmodel-compose:$version"
        const val odyssey = "com.adeo:kviewmodel-odyssey:$version"
    }

    object Navigation {
        private const val version = "1.3.1"
        const val core = "io.github.alexgladkov:odyssey-core:$version"
        const val compose = "io.github.alexgladkov:odyssey-compose:$version"
    }

    object Settings {
        private const val version = "1.0.0"
        const val core = "com.russhwolf:multiplatform-settings:$version"
        const val noargs = "com.russhwolf:multiplatform-settings-no-arg:$version"
    }

    object Ktor {
        private const val version = "2.2.3"
        const val core = "io.ktor:ktor-client-core:$version"
        const val cio = "io.ktor:ktor-client-cio:$version"
        //        const val ios = "io.ktor:ktor-client-ios:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:$version"
    }

    object Firebase {
        private const val version = "1.6.2"
        const val firestore = "dev.gitlive:firebase-firestore:$version"
        const val auth = "dev.gitlive:firebase-auth:$version"
    }

    object Resources {
        private const val version = "0.20.1"
        const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
        const val core = "dev.icerock.moko:resources:$version"
        const val compose = "dev.icerock.moko:resources-compose:$version"
    }

    object Other {
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
    }
}