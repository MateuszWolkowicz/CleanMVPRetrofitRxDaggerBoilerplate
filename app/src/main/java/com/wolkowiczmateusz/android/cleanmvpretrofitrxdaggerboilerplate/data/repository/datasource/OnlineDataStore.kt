package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity
import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import javax.inject.Inject

class OnlineDataStore @Inject
constructor(private val customApi: CustomApi,
            private val userEnitityMapper: UserEnitityMapper) {

    fun tryLogin(@NonNull vararg params: String): Observable<UserEntity> {
        return customApi.getLogin(params[0], params[1])
                .map { userEnitityMapper.userResponseToEntity(it) }
                .take(1)
    }
}

