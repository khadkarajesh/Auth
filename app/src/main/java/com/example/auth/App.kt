package com.example.auth

import android.app.Application
import com.smartmobe.auth.AuthConfig

class App : Application() {
    companion object {
        lateinit var app: Application
        fun get(): Application {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        AuthConfig.add("https://api.themoviedb.org/3/")
        app = this
    }
}