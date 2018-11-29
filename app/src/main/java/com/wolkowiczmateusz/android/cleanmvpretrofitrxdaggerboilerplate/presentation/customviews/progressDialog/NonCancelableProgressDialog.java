package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog;

import android.app.ProgressDialog;
import android.content.Context;

public class NonCancelableProgressDialog implements Dialog {

    public ProgressDialog dialog;

    @Override
    public void showDialog(Context context, String msg) {
        dialog = new ProgressDialog(context);
        dialog.setMessage(msg);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }
}
