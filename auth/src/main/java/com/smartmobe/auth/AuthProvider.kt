package com.smartmobe.auth

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri
import com.smartmobe.auth.di.networkModule
import com.smartmobe.auth.rest.service.appModule
import org.koin.android.ext.android.startKoin

class AuthProvider : ContentProvider() {
    private val applicationId = "com.smartmobe.auth.AuthProvider"
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        return null
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun onCreate(): Boolean {
        AuthConfig.setContext(context as Application)
        startKoin(context, listOf(appModule, networkModule))
        return true
    }

    override fun attachInfo(context: Context?, info: ProviderInfo?) {
        if (info == null) {
            throw NullPointerException("Library init provider cannot be null")
        }

        if (applicationId == info.authority) {
            throw  IllegalStateException("Incorrect provider authority in manifest. Most likely due to a "
                    + "missing applicationId variable in application\'s build.gradle.")
        }
        super.attachInfo(context, info)
    }

}