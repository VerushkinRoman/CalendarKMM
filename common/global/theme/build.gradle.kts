plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("org.jetbrains.compose")
    id("compose-reports-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)

                implementation(Dependencies.Resources.core)
                implementation(Dependencies.Resources.compose)

                implementation(project(":common:global:resources"))
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Other.activityCompose)
            }
        }
    }
}