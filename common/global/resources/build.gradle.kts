plugins {
    id("android-setup")
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
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
                api(Dependencies.Resources.core)
            }
        }
    }
}

multiplatformResources {
    resourcesPackage.set("resources")
}