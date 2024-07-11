plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(Dependencies.Android.gradlePlugin)
    implementation(Dependencies.Android.gradleGoogleServicesPlugin)
    implementation(Dependencies.Android.gradleGoogleCrashlyticsPlugin)
    implementation(Dependencies.Compose.gradlePlugin)
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Kotlin.Serialization.gradlePlugin)
    implementation(Dependencies.Resources.gradlePlugin)
//    implementation(Dependencies.Other.completeKotlinGradlePlugin)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}