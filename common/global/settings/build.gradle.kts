plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Settings.core)
//                implementation(Dependencies.Settings.noargs)
                implementation(project(":common:global:core"))
            }
        }
    }
}