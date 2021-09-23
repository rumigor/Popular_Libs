package com.example.mvp_example.repo



interface GitHubUserRepository {
    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?

}

