package com.example.mvp_example.presentation

import com.example.mvp_example.data.model.Repository


data class GitHubUserReposViewModel(
    val name: String,
    val forks: Int,
    val watchers: Int
) {

    object Mapper {

        fun map(repository: Repository) =
            GitHubUserReposViewModel(
                repository.name,
                repository.forks,
                repository.watchers
            )

    }
}