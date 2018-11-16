package com.smartmobe.kservice.data.rest.service

import com.crushcoder.kmovies.rest.request.ChangePasswordBody
import com.smartmobe.auth.data.rest.request.ForgotPasswordBody
import com.smartmobe.auth.data.rest.request.PasswordCreateBody
import com.smartmobe.kservice.data.rest.request.LoginBody
import com.smartmobe.kservice.data.rest.response.User
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface AuthService {
    @POST
    fun login(@Url url: String, @Body body: LoginBody): Deferred<ResponseBody>

    @POST
    fun forgotPassword(@Url url: String, @Body body: ForgotPasswordBody): Deferred<Unit>

    @PATCH("password/reset")
    fun createPassword(@Body passwordBody: PasswordCreateBody): Deferred<Unit>

    @PUT("auth/password")
    fun updatePassword(@Body changePasswordBody: ChangePasswordBody): Deferred<Unit>

    @GET("auth/me")
    fun getUser(): Deferred<String>

    @PUT("auth/me")
    fun updateUser(@Body user: User?): Deferred<User>

    @Multipart
    @POST("auth/me/avatar")
    fun updateProfilePicture(@Part image: MultipartBody.Part): Deferred<User>
}