plugins {
    id("multiplatform-setup")
    id("compose-reports-setup")
    id("org.jetbrains.compose")
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Android.Other.composeCompiler
    }
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                api(compose.foundation)
                implementation(compose.material3)
                api(compose.animation)

                api(project(":common:global:core"))
                implementation(project(":common:global:utils"))
                implementation(project(":common:global:theme"))
                implementation(project(":common:global:compose"))
                implementation(project(":common:global:presentation"))
                implementation(project(":common:global:resources"))

                implementation(Dependencies.Other.immutableCollections)

                api(Dependencies.Navigation.jetbrainsNavigation)
                api(Dependencies.ViewModel.core)
                api(Dependencies.ViewModel.compose)
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll(
                listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:stabilityConfigurationPath=$rootDir/compose_compiler_config.conf"
                )
            )
        }
    }
}