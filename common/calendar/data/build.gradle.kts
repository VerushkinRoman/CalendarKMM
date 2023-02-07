plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                api(project(":common:calendar:api"))
                implementation(project(":common:global:firebase"))
                implementation(Dependencies.Firebase.firestore)
            }
        }
    }
}