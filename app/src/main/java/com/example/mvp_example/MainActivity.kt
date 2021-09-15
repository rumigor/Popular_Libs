package com.example.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private val vb: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)


        vb.btnCounter1.setOnClickListener{
            presenter.counterClickB1()
        }
        vb.btnCounter2.setOnClickListener{
            presenter.counterClickB2()
        }
        vb.btnCounter3.setOnClickListener{
            presenter.counterClickB3()
        }
    }

    override fun setButtonText1(text: String) {
        vb.btnCounter1.text = text
    }

    override fun setButtonText2(text: String) {
        vb.btnCounter2.text = text
    }

    override fun setButtonText3(text: String) {
        vb.btnCounter3.text = text
    }

}
