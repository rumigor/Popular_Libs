package com.example.mvp_example.data.userRepositories.datasource

import com.example.mvp_example.data.model.Repository
import io.reactivex.Observable

interface UserRepositoriesDataSource {
    fun getReposbyUserLogin(userId: String): Observable<List<Repository>>
}