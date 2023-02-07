package com.posse.kotlin1.calendar

import android.app.Application
import platform.PlatformConfiguration

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun App.initPlatformSDK() = PlatformComposeSDK.init(
    configuration = PlatformConfiguration(androidContext = applicationContext)
)