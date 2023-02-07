plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Firebase.auth)
                implementation(Dependencies.Settings.core)
                implementation(project(":common:global:core"))
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Google.auth)
            }
        }
    }
}