package com.example.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_example.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private val vb: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter by moxyPresenter { Presenter(Model()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)


        vb.btnCounter1.setOnClickListener{
            presenter.counter1Click()
        }
        vb.btnCounter2.setOnClickListener{
            presenter.counter2Click()
        }
        vb.btnCounter3.setOnClickListener{
            presenter.counter3Click()
        }
    }

    override fun setCounterText1(text: String) {
        vb.btnCounter1.text = text
    }

    override fun setCounterText2(text: String) {
        vb.btnCounter2.text = text
    }

    override fun setCounterText3(text: String) {
        vb.btnCounter3.text = text
    }

}
