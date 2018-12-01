package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;


public interface BaseContractMvpPresenter<V extends BaseContractMvpView> {

    void onAttach(V MvpView);
    void onDetach();
}
