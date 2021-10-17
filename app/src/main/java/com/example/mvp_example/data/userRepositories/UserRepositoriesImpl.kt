package com.example.mvp_example.data.userRepositories

import com.example.mvp_example.data.model.Repository
import com.example.mvp_example.data.userRepositories.datasource.CacheUserRepositoriesSource
import com.example.mvp_example.data.userRepositories.datasource.CloudUserRepositoriesSource
import com.example.mvp_example.data.userRepositories.datasource.UserRepositoriesDataSource
import io.reactivex.Observable
import javax.inject.Inject

class UserRepositoriesImpl @Inject constructor(
    private val cloud: UserRepositoriesDataSource,
    private val cache: CacheUserRepositoriesSource
) : UserRepositories {
    override fun getReposbyUserLogin(userId: String): Observable<List<Repository>> =
        Observable.merge(
            cache.getReposbyUserLogin(userId),
            cloud.getReposbyUserLogin(userId)
        )
}