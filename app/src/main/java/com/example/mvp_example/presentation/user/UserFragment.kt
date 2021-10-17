package com.example.mvp_example.presentation.user


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mvp_example.R.layout.view_user
import com.example.mvp_example.arguments
import com.example.mvp_example.data.di.GitHubUserComponent
import com.example.mvp_example.data.user.GitHubUserRepository
import com.example.mvp_example.databinding.ViewUserBinding
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.scheduler.Schedulers
import com.example.mvp_example.setStartDrawableCircleImageFromUri
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class UserFragment : MvpAppCompatFragment(view_user), UserView {

    companion object Factory {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    @Inject
    lateinit var router: Router

    private var gitHubUserComponent: GitHubUserComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        gitHubUserComponent =
            (requireActivity().application as? App)
                ?.gitHubApplicationComponent
                ?.gitHubUserComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = gitHubUserRepository,
            schedulers = schedulers,
            router = router
        )
    }

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun showUser(user: GitHubUserViewModel) {
        viewBinding.userLogin.setStartDrawableCircleImageFromUri(user.avatar)
        viewBinding.userLogin.text = user.login
    }

    override fun showError(e: Throwable) {
        Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        gitHubUserComponent = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.userLogin.setOnClickListener {
            presenter.displayRepositories((it as TextView).text.toString())
        }
    }

}

