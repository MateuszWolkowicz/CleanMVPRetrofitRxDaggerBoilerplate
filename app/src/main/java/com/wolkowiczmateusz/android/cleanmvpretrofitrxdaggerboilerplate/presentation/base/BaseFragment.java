package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.CancelableProgressDialog;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.DialogTypeStrategy;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog.NonCancelableProgressDialog;

public abstract class BaseFragment<P extends BaseContractMvpPresenter> extends Fragment implements BaseContractMvpView<P> {

    private DialogTypeStrategy dialog;
    private P basePresenter;

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showProgressDialog(String msg) {
        // Strategy Pattern
        dialog = new DialogTypeStrategy(new CancelableProgressDialog());
        dialog.show(getActivity(), msg);
    }

    @Override
    public void showProgressDialog(String msg, Boolean cancelable, Boolean cancelableInTouchMode) {
        // Strategy Pattern
        if (!cancelable || !cancelableInTouchMode) {
            dialog = new DialogTypeStrategy(new CancelableProgressDialog());
        } else {
            dialog = new DialogTypeStrategy(new NonCancelableProgressDialog());
        }
        dialog.show(getActivity(), msg);
    }

    @Override
    public void showError(String exception) {
        Toast.makeText(getActivity(), exception, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void attachPresenter(P basePresenter) {
        this.basePresenter = basePresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        basePresenter.onDetach();
    }
}
