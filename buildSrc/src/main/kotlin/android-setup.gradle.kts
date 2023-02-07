plugins {
    id("com.android.library")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
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
                File(buildDir, "generated/moko/androidMain/res")
            )
        }
    }
}