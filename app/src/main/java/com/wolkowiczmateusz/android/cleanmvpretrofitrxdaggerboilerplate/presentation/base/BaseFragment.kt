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
        activity?.let { dialog.show(it, msg) }
    }

    override fun showProgressDialog(msg: String, cancelable: Boolean, cancelableInTouchMode: Boolean) {
        // Strategy Pattern
        dialog = if ((cancelable) || (cancelableInTouchMode)) {
            DialogTypeStrategy(CancelableProgressDialog())
        } else {
            DialogTypeStrategy(NonCancelableProgressDialog())
        }
        activity?.let { dialog.show(it, msg) }
    }

    override fun showError(exception: String) {
        Toast.makeText(activity, exception, Toast.LENGTH_SHORT).show()
    }


}
