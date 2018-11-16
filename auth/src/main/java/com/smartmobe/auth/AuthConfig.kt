package com.smartmobe.auth

import android.app.Application
import com.smartmobe.auth.rest.EndPoint

class AuthConfig {
    companion object {
        private lateinit var app: Application
        lateinit var endPoints: EndPoint

        fun setContext(context: Application) {
            app = context
        }

        fun setEndpoint(endPoint: EndPoint) {
            endPoints = endPoint
        }

        fun getApp(): Application {
            return app
        }
    }
}