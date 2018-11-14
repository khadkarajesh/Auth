package com.crushcoder.kmovies.rest.request

import com.google.gson.annotations.SerializedName

data class ChangePasswordBody(@SerializedName("old_password") val oldPassword: String,
                              @SerializedName("password") val newPassword: String,
                              @SerializedName("password_confirmation") val confirmPassword: String)