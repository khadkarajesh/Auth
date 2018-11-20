package com.smartmobe.modulararchitecture.ui.login

import com.smartmobe.auth.AuthConfig
import com.smartmobe.auth.base.viewmodel.BaseViewModel
import com.smartmobe.auth.bus.EventBus
import com.smartmobe.auth.bus.LoginSuccess
import com.smartmobe.auth.rest.request.LoginBody
import com.smartmobe.kservice.data.rest.service.AuthService

class LoginViewModel(private var authService: AuthService) : BaseViewModel() {
    fun login(loginBody: LoginBody, msg: String) {
        overrideDefaultProgressMessage(msg)
        execute(authService.login(AuthConfig.endPoints.login!!, loginBody)) {
            EventBus.post(LoginSuccess(it!!))
        }
    }
}