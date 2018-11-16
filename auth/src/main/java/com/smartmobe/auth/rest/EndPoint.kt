package com.smartmobe.auth.rest

class EndPoint(val login: String?,
               val forgotPassword: String?,
               val resetPassword: String?,
               val signup: String?) {
    data class Builder(var login: String? = null,
                       var forgotPassword: String? = null,
                       var resetPassword: String? = null,
                       var signup: String? = null) {
        fun login(login: String) = apply { this.login = login }
        fun forgotPassword(forgotPassword: String) = apply { this.forgotPassword = forgotPassword }
        fun resetPassword(resetPassword: String) = apply { this.resetPassword = resetPassword }
        fun signup(signup: String) = apply { this.signup = signup }
        fun build() = EndPoint(login, forgotPassword, resetPassword, signup)
    }
}


