package com.example.mvp_example

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setCounterText1(text: String)
    fun setCounterText2(text: String)
    fun setCounterText3(text: String)
}