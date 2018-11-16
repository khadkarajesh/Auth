package com.example.auth

import android.app.Application
import android.util.Log
import com.smartmobe.auth.AuthConfig
import com.smartmobe.auth.bus.AuthEvent
import com.smartmobe.auth.bus.EventBus
import com.smartmobe.auth.bus.LoginSuccess
import com.smartmobe.auth.rest.EndPoint
import com.squareup.otto.Subscribe

class App : Application() {
    companion object {
        lateinit var app: Application
        fun get(): Application {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.register(this)
        var endPoint = EndPoint.Builder()
                .login("auth/authenticate")
                .forgotPassword("password/reset")
                .resetPassword("password/reset")
                .build()

        AuthConfig.add("http://qa-diagonale.izy.as:8080/api/")
        AuthConfig.setEndpoint(endPoint)
        app = this
    }

    @Subscribe
    fun onSuccess(event: AuthEvent) {
        when (event) {
            is LoginSuccess -> {
//                var baseResponse = Gson().fromJson(event.result.string(), BaseResponse::class.java)
//                var user = baseResponse.body as User
//                Log.d("login success", "" + user.firstName)
                Log.d("login success", "called")
            }
        }
    }
}