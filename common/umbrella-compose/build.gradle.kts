plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:friends-calendar:compose"))
                api(project(":common:umbrella-common"))
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Other.activityCompose)
            }
        }
    }
}