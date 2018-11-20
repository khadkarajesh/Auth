package com.smartmobe.auth.ui.signup

import com.smartmobe.auth.AuthConfig
import com.smartmobe.auth.base.viewmodel.BaseViewModel
import com.smartmobe.auth.bus.EventBus
import com.smartmobe.auth.bus.SignupSuccess
import com.smartmobe.auth.rest.request.SignupBody
import com.smartmobe.kservice.data.rest.service.AuthService

class SignupViewModel(var authService: AuthService) : BaseViewModel() {
    fun signUp(signupBody: SignupBody) {
        execute(authService.signup(AuthConfig.endPoints.login!!, signupBody)) {
            EventBus.post(SignupSuccess(it!!))
        }
    }
}