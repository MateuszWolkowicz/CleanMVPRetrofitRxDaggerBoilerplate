package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper;



import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder;

import javax.inject.Inject;

/**
 * Created by MateuszW on 2018-05-27.
 */
public class SortOrderEntityMapper {

    @Inject
    public SortOrderEntityMapper() {
    }

    public SortOrder entityToDomain(SortOrderEntity sortOrderEntity) {
        SortOrder sortOrder = null;
        switch (sortOrderEntity) {
            case TITLE:
                return SortOrder.TITLE;
            case NO_OF_EPISODES:
                return SortOrder.NO_OF_EPISODES;
        }
        return sortOrder;
    }

    public SortOrderEntity domainToEntity(SortOrder sortOrder) {
        SortOrderEntity sortOrderEntity = null;
        switch (sortOrder) {
            case TITLE:
                return SortOrderEntity.TITLE;
            case NO_OF_EPISODES:
                return SortOrderEntity.NO_OF_EPISODES;
        }
        return sortOrderEntity;
    }
}

