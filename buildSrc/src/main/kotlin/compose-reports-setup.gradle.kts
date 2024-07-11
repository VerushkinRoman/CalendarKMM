plugins {
    kotlin("multiplatform")
}

kotlin {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach kotlinCompile@{
        val compileTaskName = this@kotlinCompile.toString()

        compilerOptions {
            if ("kapt" in compileTaskName) return@compilerOptions

            // ./gradlew assembleRelease -PcomposeCompilerReports=true
            if (project.findProperty("composeCompilerReports") == "true") {
                val path = project.layout.buildDirectory.get().asFile.absolutePath
                val reportsDestination = "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=$path/compose_compiler/"
                freeCompilerArgs.addAll(listOf("-P", reportsDestination))
            }

            if (project.findProperty("composeCompilerMetrics") == "true") {
                val path = project.layout.buildDirectory.get().asFile.absolutePath
                val metricsDestination = "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=$path/compose_compiler/"
                freeCompilerArgs.addAll(listOf("-P", metricsDestination))
            }
        }
    }
}