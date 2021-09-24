package com.example.mvp_example.presentation.user


import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mvp_example.R.layout.view_user
import com.example.mvp_example.arguments
import com.example.mvp_example.repo.GitHubUser
import com.example.mvp_example.repo.GitHubUserRepositoryFactory
import com.example.mvp_example.databinding.ViewUserBinding

class UserFragment: MvpAppCompatFragment(view_user), UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.login
    }

    override fun showError(e: Throwable) {
        Toast.makeText(context, "Пользователь не найден!", Toast.LENGTH_SHORT).show()
    }

}

