package com.smartmobe.auth.base.activity

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.crushcoder.kmovies.rest.FAILURE
import com.crushcoder.kmovies.rest.LOADING
import com.crushcoder.kmovies.rest.SUCCESS
import com.smartmobe.auth.base.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModelByClass
import kotlin.reflect.KClass


abstract class BaseActivity<out T : BaseViewModel, B : ViewDataBinding>(clazz: KClass<T>) : AppCompatActivity() {
    private val tag = BaseActivity::class.java.simpleName
    private var progressBar: ProgressBar? = null
    val viewModel: T by viewModelByClass(clazz)
    var binding: B? = null

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel.state.observe(this, Observer {
            when (it) {
                is LOADING -> {
                    showProgress()
                }
                is SUCCESS -> {
                    hideProgress()
                }
                is FAILURE -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    hideProgress()
                }
            }
        })
    }

    private fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progressBar?.visibility = View.GONE
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
