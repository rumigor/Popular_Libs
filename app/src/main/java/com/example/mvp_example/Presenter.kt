package com.example.mvp_example

class Presenter(private val mainView: MainView) {
    private val model = Model()

    fun counterClickB1() {
        val nextValue = model.next(0)
        mainView.setButtonText1(nextValue.toString())
    }
    fun counterClickB2() {
        val nextValue = model.next(1)
        mainView.setButtonText2(nextValue.toString())
    }
    fun counterClickB3() {
        val nextValue = model.next(2)
        mainView.setButtonText3(nextValue.toString())
    }

}