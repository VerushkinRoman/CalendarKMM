plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.ViewModel.core)
                implementation(Dependencies.ViewModel.compose)
                implementation(Dependencies.ViewModel.odyssey)

                implementation(project(":common:calendar:presentation"))
            }
        }
    }
}