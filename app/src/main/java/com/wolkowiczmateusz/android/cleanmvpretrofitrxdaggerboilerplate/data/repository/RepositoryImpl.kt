package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.SortOrderEntityMapper
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource.OfflineDataStore
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource.OnlineDataStore
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject
constructor(
        private val userEnitityMapper: UserEnitityMapper,
        private val sortOrderEntityMapper: SortOrderEntityMapper,
        private val offlineDataStore: OfflineDataStore,
        private val onlineDataStore: OnlineDataStore
) : Repository {

    override val loginUser: Single<User>
        get() = Single.just(offlineDataStore.loginUser)
                .map { userEnitityMapper.entityToDomain(it) }

    override val isUserLogin: Single<Boolean>
        get() = Single.defer { offlineDataStore.isUserLogin }

    override fun logoutUser(): Completable {
        return offlineDataStore.logout()
    }

    private fun sortOrderEntity(sortOrder: SortOrder): SortOrderEntity {
        return sortOrderEntityMapper.domainToEntity(sortOrder)!!
    }

    override fun tryLogin(vararg params: String): Observable<User> {
        return onlineDataStore.tryLogin(*params)
                .doOnNext { offlineDataStore.saveUserToStorage(it) }
                .map { userEnitityMapper.entityToDomain(it) }
    }
}
