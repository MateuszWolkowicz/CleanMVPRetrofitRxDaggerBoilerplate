package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog;

import android.app.ProgressDialog;
import android.content.Context;

public class CancelableProgressDialog implements Dialog {

    public ProgressDialog dialog;

    @Override
    public void showDialog(Context context, String msg) {
        dialog = new ProgressDialog(context);
        dialog.setMessage(msg);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }
}
