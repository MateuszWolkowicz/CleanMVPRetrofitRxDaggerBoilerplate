package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserMapper
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import javax.inject.Inject

class OnlineDataStore @Inject
constructor(private val customApi: CustomApi) {
    var userMapper: UserMapper = UserMapper()

    fun tryLogin(@NonNull vararg params: String): Observable<User> {
        return customApi.getLogin(params[0], params[1])
            .map { userMapper.userResponseToUser(it) }
            .take(1)
    }
}

