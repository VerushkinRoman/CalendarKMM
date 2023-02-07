plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Resources.core)
            }
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "resources"
}