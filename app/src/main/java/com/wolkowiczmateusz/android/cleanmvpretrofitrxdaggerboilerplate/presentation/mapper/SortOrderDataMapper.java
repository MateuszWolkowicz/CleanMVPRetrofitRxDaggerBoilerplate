package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.mapper;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.SortOrderModel;

import javax.inject.Inject;

class SortOrderDataMapper {

    @Inject
    public SortOrderDataMapper() {
    }

    public SortOrder modelToDomain(SortOrderModel sortOrderModel) {
        switch (sortOrderModel) {
            case TITLE:
                return SortOrder.TITLE;
            case NO_OF_EPISODES:
                return SortOrder.NO_OF_EPISODES;
        }
        return null;
    }
}
