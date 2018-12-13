package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.support.v4.app.Fragment
import android.widget.Toast

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.CancelableProgressDialog
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.DialogTypeStrategy
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.NonCancelableProgressDialog

abstract class BaseFragment : Fragment(), BaseContractMvpView {

    lateinit var dialog: DialogTypeStrategy

    override fun hideProgressDialog() {
        dialog.dismiss()
    }

    override fun showProgressDialog(msg: String) {
        // Strategy Pattern
        dialog = DialogTypeStrategy(CancelableProgressDialog())
        dialog.show(activity, msg)
    }

    override fun showProgressDialog(msg: String, cancelable: Boolean, cancelableInTouchMode: Boolean) {
        // Strategy Pattern
        if ((!cancelable) || (!cancelableInTouchMode)) {
            dialog = DialogTypeStrategy(CancelableProgressDialog())
        } else {
            dialog = DialogTypeStrategy(NonCancelableProgressDialog())
        }
        dialog.show(activity, msg)
    }

    override fun showError(exception: String) {
        Toast.makeText(activity, exception, Toast.LENGTH_SHORT).show()
    }


}
