plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:global:core"))
                implementation(project(":common:global:utils"))
                implementation(Dependencies.Kodein.core)
            }
        }
    }
}