package com.example.mvp_example.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.click
import com.example.mvp_example.databinding.ViewUserBinding
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.presentation.users.adapter.UsersAdapter.Delegate
import com.example.mvp_example.setStartDrawableCircleImageFromUri

class UserViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(user: GitHubUserViewModel, delegate: Delegate?) {
        with(viewBinding) {
            userLogin.setStartDrawableCircleImageFromUri(user.avatar)
            userLogin.text = user.login

            root.click { delegate?.onUserPicked(user) }
        }
    }

}