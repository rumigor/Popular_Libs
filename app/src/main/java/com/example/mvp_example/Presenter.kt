package com.example.mvp_example

import moxy.MvpPresenter

class Presenter(val model: Model): MvpPresenter<MainView>() {

    fun counter1Click() {
        val nextValue = model.next(0)
        viewState.setCounterText1(nextValue.toString())
    }
    fun counter2Click() {
        val nextValue = model.next(1)
        viewState.setCounterText2(nextValue.toString())
    }
    fun counter3Click() {
        val nextValue = model.next(2)
        viewState.setCounterText3(nextValue.toString())
    }

}