package com.smartmobe.auth.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.google.android.material.textfield.TextInputLayout
import com.smartmobe.auth.R
import com.smartmobe.auth.extensions.makeFullScreen
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var rootView: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        makeFullScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        rootView = window.decorView.findViewById<ViewGroup>(android.R.id.content).getChildAt(0) as LinearLayout
        rootView.children
                .filter { it is TextInputLayout }
                .map { it as TextInputLayout }
                .forEach {
                    it?.editText?.addTextChangedListener(object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            clearAllError()
                            if (s.isNullOrEmpty()) {
                                it?.error = String.format("1%s 2%s",
                                        it.editText?.hint.toString(),
                                        getString(R.string.msg_auth_empty_input_field))
                            } else if (it.id == R.id.signup_til_email
                                    && !android.util.Patterns.EMAIL_ADDRESS.matcher(signup_til_password.editText?.text).matches()) {
                                it.error = getString(R.string.msg_auth_email_invalid)
                            }
                            if (signup_til_password.editText?.text.toString()!! != signup_til_confirm_password.editText?.text.toString()) {
                                signup_til_confirm_password.error = getString(R.string.msg_auth_confirm_password_should_be_same)
                            }
                            signup_btn_submit.isEnabled = isValid()
                        }
                    })
                }
    }

    private fun clearAllError() {
        rootView.children
                .filter { it is TextInputLayout }
                .map { it as TextInputLayout }
                .forEach { it.error = null }
    }

    private fun isValid(): Boolean {
        rootView.children.forEach {
            var textInputLayout: TextInputLayout = it as TextInputLayout
            return !textInputLayout.editText?.text?.isNullOrEmpty()!!
                    || signup_til_password.editText?.text == signup_til_confirm_password.editText?.text
        }
        return true
    }
}
