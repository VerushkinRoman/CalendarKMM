plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:calendar:api"))
                implementation(Dependencies.ViewModel.core)
            }
        }
    }
}