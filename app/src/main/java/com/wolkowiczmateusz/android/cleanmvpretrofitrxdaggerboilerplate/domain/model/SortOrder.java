package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model;

/**
 * Created by MateuszW on 2018-05-24.
 */
public enum SortOrder {
    TITLE(0), NO_OF_EPISODES(1);
    public final int which;

    SortOrder(int which) {
        this.which = which;
    }
}
