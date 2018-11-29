package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model;

/**
 * Created by MateuszW on 2018-05-27.
 */
public enum SortOrderEntity {
    TITLE(0), NO_OF_EPISODES(1);
    public final int which;

    SortOrderEntity(int which) {
        this.which = which;
    }
}
