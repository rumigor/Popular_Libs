package com.example.mvp_example.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mvp_example.R.layout.view_user
import com.example.mvp_example.repo.GitHubUser

class UsersAdapter(private val delegate: Delegate?): ListAdapter<GitHubUser, UserViewHolder>(UserDiff) {

    interface Delegate {

          fun onUserPicked(user: GitHubUser)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_user, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}