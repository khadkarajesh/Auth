package com.crushcoder.kmovies.di

import com.smartmobe.kservice.data.rest.service.AuthService
import org.koin.dsl.module.module

var appModule = module {
    single { create(AuthService::class.java) }
}