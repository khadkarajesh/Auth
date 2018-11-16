package com.smartmobe.auth.rest

class EndPoint(val baseUrl: String?,
               val login: String?,
               val forgotPassword: String?,
               val resetPassword: String?,
               val signup: String?) {
    data class Builder(var baseUrl: String? = null,
                       var login: String? = null,
                       var forgotPassword: String? = null,
                       var resetPassword: String? = null,
                       var signup: String? = null) {
        fun baseUrl(url: String) = apply { this.baseUrl = url }
        fun login(login: String) = apply { this.login = login }
        fun forgotPassword(forgotPassword: String) = apply { this.forgotPassword = forgotPassword }
        fun resetPassword(resetPassword: String) = apply { this.resetPassword = resetPassword }
        fun signup(signup: String) = apply { this.signup = signup }
        fun build() = EndPoint(baseUrl, login, forgotPassword, resetPassword, signup)
    }
}


