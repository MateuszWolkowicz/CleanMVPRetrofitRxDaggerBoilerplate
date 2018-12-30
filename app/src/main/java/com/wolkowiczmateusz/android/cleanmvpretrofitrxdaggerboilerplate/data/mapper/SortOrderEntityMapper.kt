package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder

import javax.inject.Inject

class SortOrderEntityMapper @Inject
constructor() {

    fun domainToEntity(sortOrder: SortOrder): SortOrderEntity? {
        val sortOrderEntity: SortOrderEntity? = null
        return when (sortOrder) {
            SortOrder.TITLE -> SortOrderEntity.TITLE
            SortOrder.NO_OF_EPISODES -> SortOrderEntity.NO_OF_EPISODES
        }
        return sortOrderEntity
    }
}
