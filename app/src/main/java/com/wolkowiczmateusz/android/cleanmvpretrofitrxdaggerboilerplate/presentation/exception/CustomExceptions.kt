package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception

import android.content.res.Resources
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class CustomExceptions
@Inject constructor(resources: Resources) {

    @Inject
    lateinit var resources: Resources

    fun getException(throwable: Throwable): String {
        if (throwable is HttpException) {
            val retrofitResponseBody = throwable.response().errorBody()
            return getRetrofitErrorMessage(retrofitResponseBody)
        } else return if (throwable is SocketTimeoutException) {
            resources.getString(R.string.connection_to_long)
        } else if (throwable is IOException) {
            resources.getString(R.string.connection_error)
        } else {
            resources.getString(R.string.unexpected_error)
        }
    }

    private fun getRetrofitErrorMessage(responseBody: ResponseBody): String {
        try {
            var error = responseBody.string()
            try {
                val jsonObject = JSONObject(error)
                error = jsonObject.getString("error")
            } catch (e: Exception) {
            }

            return error
        } catch (e: Exception) {
            return e.message.toString()
        }

    }
}
