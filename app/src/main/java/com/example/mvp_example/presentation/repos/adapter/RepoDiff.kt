package com.example.mvp_example.presentation.repos.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.GitHubUserViewModel

object RepoDiff : DiffUtil.ItemCallback<GitHubUserReposViewModel>() {


    override fun areItemsTheSame(
        oldItem: GitHubUserReposViewModel,
        newItem: GitHubUserReposViewModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: GitHubUserReposViewModel,
        newItem: GitHubUserReposViewModel
    ): Boolean {
        return oldItem == newItem
    }

}