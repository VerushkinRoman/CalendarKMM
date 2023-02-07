plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:global:core"))
                implementation(Dependencies.Kodein.core)
            }
        }
    }
}