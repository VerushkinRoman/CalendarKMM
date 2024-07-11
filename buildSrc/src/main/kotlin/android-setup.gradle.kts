plugins {
    id("com.android.library")
}

android {
    compileSdk = 34

    namespace = "com.posse.kotlin1.calendar"

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs(
                "src/androidMain/res",
                "src/commonMain/resources",
                File(layout.buildDirectory.get().asFile, "generated/moko-resources/androidMain/res")
            )
        }
    }
}