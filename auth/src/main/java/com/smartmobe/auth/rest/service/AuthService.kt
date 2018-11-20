package com.smartmobe.kservice.data.rest.service

import com.smartmobe.auth.data.rest.request.ForgotPasswordBody
import com.smartmobe.auth.rest.request.LoginBody
import com.smartmobe.auth.rest.request.SignupBody
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface AuthService {
    @POST
    fun login(@Url url: String, @Body body: LoginBody): Deferred<ResponseBody>

    @POST
    fun forgotPassword(@Url url: String, @Body body: ForgotPasswordBody): Deferred<Unit>

    @POST
    fun signup(@Url url: String, @Body body: SignupBody): Deferred<ResponseBody>
}