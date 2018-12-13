package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers

import android.util.Patterns

class EmailMatcherWrapper {

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
