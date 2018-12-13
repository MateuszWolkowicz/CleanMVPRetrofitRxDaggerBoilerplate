package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog

import android.app.ProgressDialog
import android.content.Context

class CancelableProgressDialog : Dialog {

    lateinit var dialog: ProgressDialog

    override fun showDialog(context: Context, msg: String) {
        dialog = ProgressDialog(context)
        dialog.setMessage(msg)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
    }

    override fun dismiss() {
        dialog.dismiss()
    }
}
