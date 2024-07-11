plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("org.jetbrains.compose")
    id("compose-reports-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                api(compose.foundation)
                implementation(compose.material3)
                api(compose.animation)
                implementation(compose.materialIconsExtended)

                implementation(project(":common:global:theme"))
                implementation(project(":common:global:core"))
                implementation(project(":common:global:utils"))
                implementation(project(":common:global:presentation"))
                implementation(project(":common:global:resources"))

                implementation(Dependencies.Other.dateTime)

                implementation(Dependencies.Resources.compose)
//                implementation(Dependencies.Other.windowSizeClass)
                implementation(Dependencies.Other.windowInsets)

                api(Dependencies.Navigation.jetbrainsNavigation)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Other.core)
                implementation(Dependencies.Android.Other.activityCompose)
            }
        }
    }
}