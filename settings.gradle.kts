@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://jogamp.org/deployment/maven/") // for baseline profile
    }
}

rootProject.name = "CalendarKMM"
include(":androidApp")
include(":common:utils")
include(":common:global:core")
include(":common:global:compose")
include(":common:global:presentation")
include(":common:global:auth")
include(":common:global:firebase")
include(":common:global:navigation")
include(":common:global:settings")
include(":common:global:resources")
include(":common:global:theme")
include(":common:global:utils")
include(":common:calendar:api")
include(":common:calendar:data")
include(":common:calendar:presentation")
include(":common:calendar:compose")
include(":common:settings:api")
include(":common:settings:data")
include(":common:settings:presentation")
include(":common:settings:compose")
include(":common:friends-calendar:friends:api")
include(":common:friends-calendar:friends:data")
include(":common:friends-calendar:friends:presentation")
include(":common:friends-calendar:friends:compose")
include(":common:friends-calendar:compose")
include(":common:my-calendar:compose")
include(":common:umbrella-common")
include(":common:umbrella-compose")