package com.smartmobe.modulararchitecture.ui.login

import com.smartmobe.auth.base.viewmodel.BaseViewModel
import com.smartmobe.kservice.data.rest.request.LoginBody
import com.smartmobe.kservice.data.rest.service.AuthService

class LoginViewModel(private var authService: AuthService) : BaseViewModel() {
    fun login(loginBody: LoginBody = LoginBody("rajesh", "khadka")) {
        execute(authService.login(loginBody)) { print(it) }
    }
}