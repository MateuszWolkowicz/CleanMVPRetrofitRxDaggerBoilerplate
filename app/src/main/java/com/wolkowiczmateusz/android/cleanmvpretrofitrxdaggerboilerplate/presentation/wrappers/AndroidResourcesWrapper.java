package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers;

import android.util.Patterns;

/**
 * Created by MateuszW on 2018-06-28.
 */
public class AndroidResourcesWrapper {

    public boolean getResource(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
