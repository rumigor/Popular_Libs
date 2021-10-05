package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

class CacheUserDataSourceImpl : CacheUserDataSource {

    private val cache = mutableListOf<GitHubUser>()

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(cache)

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.firstOrNull { user -> user.login.contentEquals(userId) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        Single.fromCallable {
            cache.clear()
            cache.addAll(users)
            cache
        }

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        Single.fromCallable { user }

}