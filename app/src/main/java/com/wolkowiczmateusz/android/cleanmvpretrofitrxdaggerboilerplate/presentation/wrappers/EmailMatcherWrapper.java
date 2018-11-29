package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers;

import android.util.Patterns;

/**
 * Created by MateuszW on 2018-06-26.
 */
public class EmailMatcherWrapper {

    public boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
