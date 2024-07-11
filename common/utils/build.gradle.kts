plugins {
    kotlin("multiplatform")
    id("android-setup")
    id("org.jetbrains.compose")
    id("compose-reports-setup")
}

kotlin {
    androidTarget()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    jvmToolchain(17)

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(Dependencies.Navigation.jetbrainsNavigation)
                implementation(Dependencies.Other.windowSizeClass)
                api(Dependencies.Kotlin.Coroutines.core)
                api(Dependencies.ViewModel.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Other.composeLifecycle)
            }
        }
    }
}