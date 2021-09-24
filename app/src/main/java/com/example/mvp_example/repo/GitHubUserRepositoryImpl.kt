package com.example.mvp_example.repo

import io.reactivex.rxjava3.core.Single
import java.lang.RuntimeException

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val users = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
    )

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(users)


    override fun getUserByLogin(userId: String): Single<GitHubUser> =
        users.firstOrNull {user -> user.login.contentEquals(userId)}
            ?.let{user -> Single.just(user)}
            ?: Single.error(RuntimeException("Пользователь с ником $userId не найден!"))

}