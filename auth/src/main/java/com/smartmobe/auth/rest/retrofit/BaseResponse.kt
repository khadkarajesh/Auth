package com.smartmobe.auth.rest.retrofit

import com.google.gson.annotations.SerializedName


class BaseResponse<R> {
    @SerializedName("body")
    val body: R? = null
}
