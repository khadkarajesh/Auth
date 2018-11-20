package com.smartmobe.auth.extensions

import android.content.Context
import android.net.ConnectivityManager

/**
 * Checks network connectivity
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = this
            .getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    connectivityManager?.let {
        val netInfo = it.activeNetworkInfo
        netInfo?.let {
            if (netInfo.isConnected) return true
        }
    }
    return false
}