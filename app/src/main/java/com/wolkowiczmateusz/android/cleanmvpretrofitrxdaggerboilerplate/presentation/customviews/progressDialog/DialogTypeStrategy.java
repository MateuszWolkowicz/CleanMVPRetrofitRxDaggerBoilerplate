package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog;

import android.content.Context;

public class DialogTypeStrategy {

    Dialog dialog;

    public DialogTypeStrategy(Dialog dialog) {
        this.dialog = dialog;
    }

    public void show(Context context, String msg) {
        dialog.showDialog(context, msg);
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
