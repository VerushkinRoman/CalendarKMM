plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Kotlin.Coroutines.core)
                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Other.dateTime)
                implementation(project(":common:global:core"))
                implementation(project(":common:global:resources"))
//                implementation(project(":common:global:repository:settings:api"))
            }
        }
    }
}