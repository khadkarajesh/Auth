package com.smartmobe.auth.rest.retrofit


class BaseResponse<R> {
    val body: R? = null

    val page: Int = 0
    val total_results: Int = 0
    val total_pages: Int = 0
}
