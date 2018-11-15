package com.smartmobe.auth.rest.service

import com.smartmobe.auth.di.create
import com.smartmobe.kservice.data.rest.service.AuthService
import com.smartmobe.modulararchitecture.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var appModule = module {
    single { create(AuthService::class.java) }
    viewModel { LoginViewModel(get()) }
}