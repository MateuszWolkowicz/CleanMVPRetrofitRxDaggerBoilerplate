package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.progressDialog;

import android.content.Context;

public interface Dialog {

    void showDialog(Context context, String msg);
    void dismiss();
}
