plugins {
    id("android-setup")
    kotlin("multiplatform")
    kotlin("kapt")
//    id("com.louiscad.complete-kotlin")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    jvmToolchain(17)

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:utils"))
            }
        }
    }
}