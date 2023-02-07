plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:global:utils"))
                api(Dependencies.Kotlin.Coroutines.core)
                implementation(Dependencies.Other.dateTime)
            }
        }
    }
}