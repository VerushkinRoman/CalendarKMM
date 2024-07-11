plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material)

                implementation(Dependencies.ViewModel.core)
                implementation(Dependencies.ViewModel.compose)

                implementation(project(":common:calendar:presentation"))
            }
        }
    }
}