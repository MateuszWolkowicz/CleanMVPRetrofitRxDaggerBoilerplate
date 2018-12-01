package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers;

import android.util.Patterns;


public class AndroidResourcesWrapper {

    public boolean getResource(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
