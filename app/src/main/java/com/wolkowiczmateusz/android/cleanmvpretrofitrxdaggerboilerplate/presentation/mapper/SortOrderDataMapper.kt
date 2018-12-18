package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.SortOrderModel

import javax.inject.Inject

internal class SortOrderDataMapper @Inject
constructor() {

    fun modelToDomain(sortOrderModel: SortOrderModel): SortOrder? {
        return when (sortOrderModel) {
            SortOrderModel.TITLE -> SortOrder.TITLE
            SortOrderModel.NO_OF_EPISODES -> SortOrder.NO_OF_EPISODES
        }
        return null
    }
}
