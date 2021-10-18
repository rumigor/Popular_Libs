package com.example.mvp_example.presentation.repos.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.mvp_example.presentation.GitHubUserViewModel

object RepoDiff : DiffUtil.ItemCallback<GitHubUserViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem.login == newItem.login
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel) = payload

}