package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

interface BaseContractMvpView {

    fun hideProgressDialog()
    fun showProgressDialog(msg: String)
    fun showProgressDialog(msg: String, cancelable: Boolean, cancelableInTouchMode: Boolean)
    fun showError(exception: String)
}
