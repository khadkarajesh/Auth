package com.example.auth

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.smartmobe.auth.AuthConfig
import com.smartmobe.auth.bus.AuthEvent
import com.smartmobe.auth.bus.EventBus
import com.smartmobe.auth.bus.LoginSuccess
import com.smartmobe.auth.rest.EndPoint
import com.smartmobe.auth.rest.retrofit.BaseResponse
import com.smartmobe.kservice.data.rest.response.User
import com.squareup.otto.Subscribe

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        EventBus.register(this)

        var endPoint = EndPoint.Builder()
                .baseUrl("http://qa-diagonale.izy.as:8080/api/")
                .login("auth/authenticate")
                .forgotPassword("password/reset")
                .resetPassword("password/reset")
                .build()

        AuthConfig.setEndpoint(endPoint)
    }

    @Subscribe
    fun onSuccess(event: AuthEvent) {
        when (event) {
            is LoginSuccess -> {
                var baseResponse: BaseResponse<*>? = Gson().fromJson(event.result.string(), BaseResponse::class.java)
                var user = baseResponse?.body as User
                Log.d("login success", "called " + user.firstName)
            }
        }
    }
}