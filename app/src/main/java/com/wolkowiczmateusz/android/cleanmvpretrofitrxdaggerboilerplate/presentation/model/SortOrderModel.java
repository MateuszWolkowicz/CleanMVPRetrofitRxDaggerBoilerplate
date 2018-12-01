package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model;

public enum SortOrderModel {
    TITLE(0), NO_OF_EPISODES(1);
    public final int which;

    SortOrderModel(int which) {
        this.which = which;
    }
}