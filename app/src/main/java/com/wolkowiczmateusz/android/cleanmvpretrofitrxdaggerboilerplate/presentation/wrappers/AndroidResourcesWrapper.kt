package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers

import android.util.Patterns

class AndroidResourcesWrapper {

    fun getResource(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
