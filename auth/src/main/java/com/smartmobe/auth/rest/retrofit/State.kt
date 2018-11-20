package com.smartmobe.auth.rest.retrofit

sealed class State
class LOADING(var message: String) : State()
object SUCCESS : State()
class FAILURE(var message: String) : State()
object NetworkFailureState : State()