package com.smartmobe.auth.rest.request

data class SignupBody(val username: String, val email: String, val password: String)
data class LoginBody(val username: String, val password: String)