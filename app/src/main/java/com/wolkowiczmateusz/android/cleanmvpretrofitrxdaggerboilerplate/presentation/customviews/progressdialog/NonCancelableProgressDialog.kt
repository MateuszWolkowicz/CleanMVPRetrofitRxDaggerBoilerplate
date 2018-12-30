package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressdialog

import android.app.ProgressDialog
import android.content.Context

class NonCancelableProgressDialog : Dialog {

    private lateinit var dialog: ProgressDialog

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
