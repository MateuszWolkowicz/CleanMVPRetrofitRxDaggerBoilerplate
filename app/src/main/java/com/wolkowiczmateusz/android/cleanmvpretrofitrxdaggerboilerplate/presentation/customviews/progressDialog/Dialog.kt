package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog

import android.content.Context

interface Dialog {

    fun showDialog(context: Context, msg: String)
    fun dismiss()
}
