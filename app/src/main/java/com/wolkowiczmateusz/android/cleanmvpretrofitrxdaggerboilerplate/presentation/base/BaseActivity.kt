package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.CancelableProgressDialog
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.DialogTypeStrategy
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.NonCancelableProgressDialog

abstract class BaseActivity : AppCompatActivity(), BaseContractMvpView {

    lateinit var dialog: DialogTypeStrategy

    override fun hideProgressDialog() {
        dialog.dismiss()
    }

    override fun showProgressDialog(msg: String) {
        // Strategy Pattern
        dialog = DialogTypeStrategy(CancelableProgressDialog())
        dialog.show(this, msg)
    }

    override fun showProgressDialog(msg: String, cancelable: Boolean, cancelableInTouchMode: Boolean) {
        // Strategy Pattern
        dialog = if ((cancelable) || (cancelableInTouchMode)) {
            DialogTypeStrategy(CancelableProgressDialog())
        } else {
            DialogTypeStrategy(NonCancelableProgressDialog())
        }
        dialog.show(this, msg)
    }

    override fun showError(exception: String) {
        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show()
    }

}
