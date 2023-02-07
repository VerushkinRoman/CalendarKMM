plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    android()

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.material)
                implementation(compose.runtime)
                implementation(compose.foundation)

                implementation(Dependencies.Navigation.core)
                implementation(Dependencies.Navigation.compose)

                implementation(Dependencies.ViewModel.core)
                implementation(Dependencies.ViewModel.compose)
                implementation(Dependencies.ViewModel.odyssey)

                implementation(project(":common:global:resources"))
                implementation(project(":common:global:navigation"))
                implementation(project(":common:global:theme"))
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}