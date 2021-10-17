package com.example.mvp_example.data.userRepositories

import com.example.mvp_example.data.model.Repository
import io.reactivex.Observable

interface UserRepositories {
    fun getReposbyUserLogin(userId: String): Observable<List<Repository>>
}
