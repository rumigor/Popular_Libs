package com.example.mvp_example.repo

object GitHubUserRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}