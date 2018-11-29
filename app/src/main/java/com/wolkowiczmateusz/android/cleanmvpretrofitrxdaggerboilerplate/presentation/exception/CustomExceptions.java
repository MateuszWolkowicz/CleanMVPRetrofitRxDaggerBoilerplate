package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception;

import android.content.res.Resources;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class CustomExceptions {

    @Inject
    Resources resources;

    @Inject
    public CustomExceptions(Resources resources) {
        this.resources = resources;
    }

    public String getException(Throwable throwable) {
        if (throwable instanceof HttpException) {
            ResponseBody retrofitResponseBody = ((HttpException) throwable).response().errorBody();
            return getRetrofitErrorMessage(retrofitResponseBody);
        } else if (throwable instanceof SocketTimeoutException) {
            return resources.getString(R.string.connection_to_long);
        } else if (throwable instanceof IOException) {
            return resources.getString(R.string.connection_error);
        } else {
            return resources.getString(R.string.unexpected_error);
        }
    }

    private String getRetrofitErrorMessage(ResponseBody responseBody) {
        try {
            String error = responseBody.string();
            try {
                JSONObject jsonObject = new JSONObject(error);
                error = jsonObject.getString("error");
            } catch (Exception e) {
            }
            return error;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
