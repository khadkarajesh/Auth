package com.smartmobe.auth.bus

import okhttp3.ResponseBody

sealed class AuthEvent
class LoginSuccess(val result: ResponseBody) : AuthEvent()
class SignupSuccess(val result: ResponseBody) : AuthEvent()