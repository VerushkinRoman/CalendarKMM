plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(project(":common:friends-calendar:compose"))
                implementation(project(":common:global:core"))
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Other.activity)
            }
        }
    }
}