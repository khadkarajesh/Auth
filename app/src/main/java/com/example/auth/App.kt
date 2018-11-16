package com.example.auth

import android.app.Application
import android.content.Intent
import android.util.Log
import com.example.auth.ui.dashboard.DashboardActivity
import com.google.gson.Gson
import com.smartmobe.auth.AuthConfig
import com.smartmobe.auth.bus.AuthEvent
import com.smartmobe.auth.bus.EventBus
import com.smartmobe.auth.bus.LoginSuccess
import com.smartmobe.auth.rest.EndPoint
import com.smartmobe.auth.rest.retrofit.BaseResponse
import com.smartmobe.kservice.data.rest.response.User
import com.squareup.otto.Subscribe
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

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
                var baseResponse: BaseResponse<User> = Gson().fromJson(event.result.string(),
                        getType(BaseResponse::class.java, User::class.java))
                Log.d("login success", "called " + baseResponse.body?.firstName)
                this.startActivity(Intent(this, DashboardActivity::class.java))
            }
        }
    }

    /**
     * serializing the generics
     * <a href="https://dzone.com/articles/deserialization-1"></a>
     */
    private fun getType(rawClass: Class<*>, parameterClass: Class<*>): Type {
        return object : ParameterizedType {
            override fun getRawType(): Type {
                return rawClass
            }

            override fun getOwnerType(): Type? {
                return null
            }

            override fun getActualTypeArguments(): Array<Type> {
                return arrayOf(parameterClass)
            }
        }
    }
}