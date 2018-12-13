package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog

import android.app.ProgressDialog
import android.content.Context

class NonCancelableProgressDialog : Dialog {

    lateinit var dialog: ProgressDialog

    override fun showDialog(context: Context, msg: String) {
        dialog = ProgressDialog(context)
        dialog.setMessage(msg)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    override fun dismiss() {
        dialog.dismiss()
    }
}
