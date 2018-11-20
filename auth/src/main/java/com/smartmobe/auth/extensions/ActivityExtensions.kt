package com.smartmobe.auth.extensions

import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.makeFullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    supportActionBar?.hide()
}