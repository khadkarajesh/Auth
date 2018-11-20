package com.smartmobe.auth.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.smartmobe.auth.R
import com.smartmobe.auth.base.activity.BaseActivity
import com.smartmobe.auth.extensions.makeFullScreen
import com.smartmobe.auth.ui.signup.SignupActivity
import com.smartmobe.kservice.data.rest.request.LoginBody
import com.smartmobe.modulararchitecture.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>(LoginViewModel::class) {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        makeFullScreen()
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SignupActivity::class.java))
        login_btn_submit.isEnabled = isValid()
        login_edt_username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login_til_username.error = null
                if (s.isNullOrEmpty()) {
                    login_til_username.error = getString(R.string.msg_auth_username_empty)
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    login_til_username.error = getString(R.string.msg_auth_email_invalid)
                }
                login_btn_submit.isEnabled = isValid()
            }
        })

        login_edt_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login_til_password.error = null
                if (s.isNullOrEmpty()) {
                    login_til_password?.error = getString(R.string.msg_auth_password_empty)
                }
                login_btn_submit.isEnabled = isValid()
            }
        })

        login_btn_submit.setOnClickListener {
            if (isValid()) {
                viewModel.login(LoginBody(login_edt_username.text.toString(), login_edt_password.text.toString())
                        , getString(R.string.msg_auth_logging_in))
            }
        }

        login_tv_forget_password.setOnClickListener { }
    }

    fun isValid(): Boolean {
        return !login_edt_username.text.isNullOrEmpty()
                && android.util.Patterns.EMAIL_ADDRESS.matcher(login_edt_username.text).matches()
                && !login_edt_password.text.isNullOrEmpty()
    }
}
