package com.smartmobe.auth.data.rest.request

import com.google.gson.annotations.SerializedName

data class PasswordCreateBody(@SerializedName("token") val token: String,
                              @SerializedName("email") val email: String,
                              @SerializedName("password") val password: String,
                              @SerializedName("password_confirmation") val confirmPassword: String)