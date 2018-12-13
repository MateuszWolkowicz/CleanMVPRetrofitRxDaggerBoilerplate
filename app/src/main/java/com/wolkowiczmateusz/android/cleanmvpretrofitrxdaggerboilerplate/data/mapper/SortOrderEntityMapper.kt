package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder

import javax.inject.Inject

class SortOrderEntityMapper @Inject
constructor() {

    fun entityToDomain(sortOrderEntity: SortOrderEntity): SortOrder? {
        val sortOrder: SortOrder? = null
        when (sortOrderEntity) {
            SortOrderEntity.TITLE -> return SortOrder.TITLE
            SortOrderEntity.NO_OF_EPISODES -> return SortOrder.NO_OF_EPISODES
        }
        return sortOrder
    }

    fun domainToEntity(sortOrder: SortOrder): SortOrderEntity? {
        val sortOrderEntity: SortOrderEntity? = null
        when (sortOrder) {
            SortOrder.TITLE -> return SortOrderEntity.TITLE
            SortOrder.NO_OF_EPISODES -> return SortOrderEntity.NO_OF_EPISODES
        }
        return sortOrderEntity
    }
}

