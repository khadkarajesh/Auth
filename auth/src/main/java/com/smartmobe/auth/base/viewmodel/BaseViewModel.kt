package com.smartmobe.auth.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crushcoder.kmovies.rest.FAILURE
import com.crushcoder.kmovies.rest.LOADING
import com.crushcoder.kmovies.rest.SUCCESS
import com.crushcoder.kmovies.rest.State
import com.crushcoder.kmovies.rest.retrofit.Result
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.standalone.KoinComponent
import retrofit2.HttpException


abstract class BaseViewModel : ViewModel(), KoinComponent {
    var state: MutableLiveData<State> = MutableLiveData()
    var loadingMessage = ""


    fun overrideDefaultProgressMessage(message: String) {
        loadingMessage = message
    }

    fun <T> execute(app: Deferred<T>, success: Result<T>) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                state.value = LOADING(loadingMessage)
                success.success(app.await())
                state.value = SUCCESS
            } catch (e: Throwable) {
                state.value = FAILURE(e.localizedMessage)
            } catch (e: Exception) {
                state.value = FAILURE(e.message!!)
            }
        }
    }


    fun <T> execute(app: Deferred<T>, response: (T?) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                state.value = LOADING(loadingMessage)
                response(app.await())
                state.value = SUCCESS
            } catch (e: HttpException) {
                state.value = FAILURE(e.message!!)
            } catch (e: Exception) {
                state.value = FAILURE(e.message!!)
            }
        }
    }
}