plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Ktor.core)
                implementation(project(":common:global:core"))
                implementation(project(":common:global:resources"))
            }
        }
    }
}