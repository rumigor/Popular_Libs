package com.example.mvp_example.data.userRepositories.datasource

import com.example.mvp_example.data.model.Repository
import io.reactivex.Single

interface CacheUserRepositoriesSource : UserRepositoriesDataSource {
    fun retainRepos(userId: String, repos: List<Repository>): Single<List<Repository>>
}