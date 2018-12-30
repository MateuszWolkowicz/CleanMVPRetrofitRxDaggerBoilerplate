package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.support.v4.app.Fragment
import android.widget.Toast

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressdialog.CancelableProgressDialog
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressdialog.DialogType
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressdialog.NonCancelableProgressDialog

abstract class BaseFragment : Fragment(), BaseContractMvpView {

    private lateinit var dialog: DialogType

    override fun hideProgressDialog() {
        dialog.dismiss()
    }

    override fun showProgressDialog(msg: String) {
        // Strategy Pattern
        dialog = DialogType(CancelableProgressDialog())
        activity?.let { dialog.show(it, msg) }
    }

    override fun showProgressDialog(
        msg: String,
        cancelable: Boolean,
        cancelableInTouchMode: Boolean
    ) {
        // Strategy Pattern
        dialog = if ((cancelable) || (cancelableInTouchMode)) {
            DialogType(CancelableProgressDialog())
        } else {
            DialogType(NonCancelableProgressDialog())
        }
        activity?.let { dialog.show(it, msg) }
    }

    override fun showError(exception: String) {
        Toast.makeText(activity, exception, Toast.LENGTH_SHORT).show()
    }
}
