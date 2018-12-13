package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api

import okhttp3.ResponseBody
import retrofit2.Retrofit
import java.io.IOException

class ErrorConverter(private val retrofit: Retrofit) {

    fun convert(responseBody: ResponseBody): ErrorResponse? {
        val converter = retrofit.responseBodyConverter<ErrorResponse>(ErrorResponse::class.java, arrayOf())
        return try {
            converter.convert(responseBody)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }

    }
}
