package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

interface BaseContractMvpPresenter<V : BaseContractMvpView> {

    fun onAttach(mvpView: V)
    fun onDetach()
}
