plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:global:resources"))
                implementation(project(":common:global:utils"))
            }
        }
    }
}