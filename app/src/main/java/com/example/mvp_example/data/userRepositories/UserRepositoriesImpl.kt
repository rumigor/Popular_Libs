package com.example.mvp_example.data.userRepositories

import com.example.mvp_example.data.model.Repository
import com.example.mvp_example.data.userRepositories.datasource.CloudUserRepositoriesSource
import io.reactivex.Observable
import javax.inject.Inject

class UserRepositoriesImpl @Inject constructor(
    private val cloud: CloudUserRepositoriesSource
) : UserRepositories {
    override fun getReposbyUserLogin(userId: String): Observable<List<Repository>> =
        Observable.merge(cloud.getReposbyUserLogin(userId).flatMapSingle () )
}