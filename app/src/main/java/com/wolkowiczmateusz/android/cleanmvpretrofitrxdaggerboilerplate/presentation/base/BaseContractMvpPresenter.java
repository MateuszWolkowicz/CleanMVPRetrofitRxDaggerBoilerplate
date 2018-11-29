package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;

/**
 * Created by MateuszW on 2018-04-10.
 */
public interface BaseContractMvpPresenter<V extends BaseContractMvpView> {

    void onAttach(V MvpView);
    void onDetach();
}
