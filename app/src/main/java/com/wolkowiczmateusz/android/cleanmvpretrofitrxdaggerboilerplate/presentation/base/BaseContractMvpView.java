package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;

/**
 * Created by MateuszW on 2018-04-11.
 */
public interface BaseContractMvpView<P extends BaseContractMvpPresenter> {

    void hideProgressDialog();
    void showProgressDialog(String msg);
    void showProgressDialog(String msg, Boolean cancelable, Boolean cancelableInTouchMode);
    void showError(String exception);
    void attachPresenter(P basePresenter);
}
