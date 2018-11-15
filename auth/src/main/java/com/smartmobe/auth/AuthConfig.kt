package com.smartmobe.auth

import android.app.Application

class AuthConfig {
    companion object {
        private lateinit var url: String
        private lateinit var app: Application

        fun getUrl(): String {
            return url
        }

        fun setContext(context: Application) {
            app = context
        }

        fun add(apiUrl: String) {
            url = apiUrl
        }

        fun getApp(): Application {
            return app
        }
    }
}