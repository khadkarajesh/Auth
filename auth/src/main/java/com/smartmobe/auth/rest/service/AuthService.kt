package com.smartmobe.kservice.data.rest.service

import com.crushcoder.kmovies.rest.request.ChangePasswordBody
import com.smartmobe.auth.data.rest.request.ForgotPasswordBody
import com.smartmobe.auth.data.rest.request.PasswordCreateBody
import com.smartmobe.kservice.data.rest.request.LoginBody
import com.smartmobe.kservice.data.rest.response.User
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import retrofit2.http.*

interface AuthService {
    @POST("auth/authenticate")
    fun login(@Body body: LoginBody): Deferred<User>

    @POST("password/reset")
    fun forgotPassword(@Body body: ForgotPasswordBody): Deferred<Unit>

    @PATCH("password/reset")
    fun createPassword(@Body passwordBody: PasswordCreateBody): Deferred<Unit>

    @PUT("auth/password")
    fun updatePassword(@Body changePasswordBody: ChangePasswordBody): Deferred<Unit>

    @GET("auth/me")
    fun getUser(): Deferred<User>

    @PUT("auth/me")
    fun updateUser(@Body user: User?): Deferred<User>

    @Multipart
    @POST("auth/me/avatar")
    fun updateProfilePicture(@Part image: MultipartBody.Part): Deferred<User>
}