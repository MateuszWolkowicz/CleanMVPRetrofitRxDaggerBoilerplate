package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog

import android.content.Context

class DialogTypeStrategy(var dialog: Dialog) {

    fun show(context: Context, msg: String) {
        dialog.showDialog(context, msg)
    }

    fun dismiss() {
        dialog.dismiss()
    }
}
