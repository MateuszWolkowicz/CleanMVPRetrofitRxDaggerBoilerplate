package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.CancelableProgressDialog
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.DialogType
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.NonCancelableProgressDialog

abstract class BaseActivity : AppCompatActivity(), BaseContractMvpView {

    abstract val layoutId: Int
    protected abstract fun initializeDagger()
    protected abstract fun attachPresenter()
    protected abstract fun detachPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeDagger()
        attachPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachPresenter()
    }

    lateinit var dialog: DialogType

    override fun hideProgressDialog() {
        dialog.dismiss()
    }

    override fun showProgressDialog(msg: String) {
        // Strategy Pattern
        dialog = DialogType(CancelableProgressDialog())
        dialog.show(this, msg)
    }

    override fun showProgressDialog(msg: String, cancelable: Boolean, cancelableInTouchMode: Boolean) {
        // Strategy Pattern
        dialog = if ((cancelable) || (cancelableInTouchMode)) {
            DialogType(CancelableProgressDialog())
        } else {
            DialogType(NonCancelableProgressDialog())
        }
        dialog.show(this, msg)
    }

    override fun showError(exception: String) {
        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show()
    }

}
