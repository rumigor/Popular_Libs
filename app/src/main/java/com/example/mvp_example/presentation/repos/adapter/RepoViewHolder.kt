//package com.example.mvp_example.presentation.repos.adapter
//
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.example.mvp_example.click
//import com.example.mvp_example.databinding.ViewUserBinding
//import com.example.mvp_example.presentation.GitHubUserReposViewModel
//import com.example.mvp_example.presentation.GitHubUserViewModel
//import com.example.mvp_example.presentation.users.adapter.UsersAdapter
//import com.example.mvp_example.setStartDrawableCircleImageFromUri
//
//class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//    private val viewBinding: ViewUserBinding by viewBinding()
//
//    fun bind(user: GitHubUserReposViewModel) {
//        with(viewBinding) {
//            userLogin.text = user.name
//        }
//    }
//}