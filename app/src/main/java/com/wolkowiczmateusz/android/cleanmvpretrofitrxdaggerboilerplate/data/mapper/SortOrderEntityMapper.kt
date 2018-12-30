package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder

import javax.inject.Inject

class SortOrderEntityMapper @Inject
constructor() {

    fun entityToDomain(sortOrderEntity: SortOrderEntity): SortOrder? {
        val sortOrder: SortOrder? = null
        return when (sortOrderEntity) {
            SortOrderEntity.TITLE -> SortOrder.TITLE
            SortOrderEntity.NO_OF_EPISODES -> SortOrder.NO_OF_EPISODES
        }
        return sortOrder
    }

    fun domainToEntity(sortOrder: SortOrder): SortOrderEntity? {
        val sortOrderEntity: SortOrderEntity? = null
        return when (sortOrder) {
            SortOrder.TITLE -> SortOrderEntity.TITLE
            SortOrder.NO_OF_EPISODES -> SortOrderEntity.NO_OF_EPISODES
        }
        return sortOrderEntity
    }
}
