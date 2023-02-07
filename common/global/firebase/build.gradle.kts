plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Firebase.firestore)
                implementation(Dependencies.Firebase.auth)
                implementation(project(":common:global:core"))
            }
        }
    }
}