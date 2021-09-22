package com.example.mvp_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_example.databinding.FragmentUserinfoBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserInfoFragment : MvpAppCompatFragment(), UserInfoView {

    private var name: String? = null

    companion object {
        fun newInstance(userName: String): UserInfoFragment {
            val userInfoFragment = UserInfoFragment()
            val args = Bundle()
            args.putString("USER_NAME", userName)
            userInfoFragment.arguments = args
            return userInfoFragment
        }
    }

    val presenter: UserInfoPresenter by moxyPresenter { UserInfoPresenter(App.instance.router) }

    private var vb: FragmentUserinfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            name = requireArguments().getString("USER_NAME")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentUserinfoBinding.inflate(inflater, container, false).also {
                vb = it
            }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb?.userName?.text = name
    }

}

