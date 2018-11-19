package com.smartmobe.auth.ui.signup

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.smartmobe.auth.R
import org.jetbrains.anko.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
            }
            editText {
                hint = "Password"
            }
            button("Login") {
            }
        }

        setOnclickListener {
        }
    }

    fun doAsync(f: () -> Unit) {
        Thread { f }.start()
    }

    fun setOnclickListener(listener: (View) -> Unit) {
        listener
    }
}
