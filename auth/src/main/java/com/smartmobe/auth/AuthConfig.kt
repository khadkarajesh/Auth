package com.smartmobe.auth

import android.app.Application
import com.smartmobe.auth.rest.EndPoint

class AuthConfig {
    companion object {
        private lateinit var url: String
        private lateinit var app: Application
        lateinit var endPoints: EndPoint

        fun getUrl(): String {
            return url
        }

        fun setContext(context: Application) {
            app = context
        }

        fun add(apiUrl: String) {
            url = apiUrl
        }

        fun setEndpoint(endPoint: EndPoint) {
            endPoints = endPoint
        }

        fun getApp(): Application {
            return app
        }
    }
}