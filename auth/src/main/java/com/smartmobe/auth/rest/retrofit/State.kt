package com.crushcoder.kmovies.rest

sealed class State
class LOADING(var message: String) : State()
object SUCCESS : State()
class FAILURE(var message: String) : State()