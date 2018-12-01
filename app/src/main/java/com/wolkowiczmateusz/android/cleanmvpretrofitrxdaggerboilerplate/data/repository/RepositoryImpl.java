package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.SortOrderEntityMapper;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.SortOrderEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource.OfflineDataStore;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource.OnlineDataStore;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.SortOrder;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class RepositoryImpl implements Repository {

    private UserEnitityMapper userEnitityMapper;
    private SortOrderEntityMapper sortOrderEntityMapper;
    private OfflineDataStore offlineDataStore;
    private OnlineDataStore onlineDataStore;

    @Inject
    public RepositoryImpl(
            UserEnitityMapper userEnitityMapper,
            SortOrderEntityMapper sortOrderEntityMapper,
            OfflineDataStore offlineDataStore,
            OnlineDataStore onlineDataStore
    ) {
        this.userEnitityMapper = userEnitityMapper;
        this.sortOrderEntityMapper = sortOrderEntityMapper;
        this.offlineDataStore = offlineDataStore;
        this.onlineDataStore = onlineDataStore;
    }

    @Override
    public Single<User> getLoginUser() {
        return Single.just(offlineDataStore.getLoginUser())
                .map(userEnitityMapper::entityToDomain);
    }

    @Override
    public Completable logoutUser() {
        return offlineDataStore.logout();
    }

    @Override
    public Single<Boolean> isUserLogin() {
        return Single.defer(offlineDataStore::isUserLogin);
    }

    private SortOrderEntity sortOrderEntity(SortOrder sortOrder) {
        return sortOrderEntityMapper.domainToEntity(sortOrder);
    }

    @Override
    public Observable<User> tryLogin(String... params) {
        return onlineDataStore.tryLogin(params)
                .doOnNext(offlineDataStore::saveUserToStorage)
                .map(userEnitityMapper::entityToDomain);
    }
}
