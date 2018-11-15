package com.smartmobe.auth.ui

import android.os.Bundle
import com.smartmobe.auth.R
import com.smartmobe.auth.base.activity.BaseActivity
import com.smartmobe.modulararchitecture.ui.login.LoginViewModel

class LoginActivity : BaseActivity<LoginViewModel>(LoginViewModel::class) {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.login()
    }
}
