package com.smartmobe.auth.base.activity

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.crushcoder.kmovies.rest.FAILURE
import com.crushcoder.kmovies.rest.LOADING
import com.crushcoder.kmovies.rest.SUCCESS
import com.smartmobe.auth.R
import com.smartmobe.auth.base.viewmodel.BaseViewModel
import com.smartmobe.auth.bus.EventBus
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog
import org.koin.androidx.viewmodel.ext.android.viewModelByClass
import kotlin.reflect.KClass


abstract class BaseActivity<out T : BaseViewModel>(clazz: KClass<T>) : AppCompatActivity() {
    private val tag = BaseActivity::class.java.simpleName
    private lateinit var dialog: ProgressDialog
    val viewModel: T by viewModelByClass(clazz)
    //var binding: B? = null

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.register(this)
        setContentView(getLayoutId())
        //binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel.loadingMessage = getString(R.string.msg_auth_loading)
        viewModel.state.observe(this, Observer {
            when (it) {
                is LOADING -> {
                    dialog = indeterminateProgressDialog(it.message)
                    dialog.show()
                }
                is SUCCESS -> {
                    hideProgress()
                }
                is FAILURE -> {
                    hideProgress()
                    showDialog(it.message)
                }
            }
        })
    }

    override fun onDestroy() {
        EventBus.unregister(this)
        super.onDestroy()
    }

    private fun showProgress(message: String) {
        indeterminateProgressDialog(message).show()
    }

    private fun hideProgress() {
        dialog.hide()
    }

    private fun showDialog(message: String) {
        alert(message) { positiveButton(android.R.string.ok) { it.dismiss() } }.show()
    }
}
