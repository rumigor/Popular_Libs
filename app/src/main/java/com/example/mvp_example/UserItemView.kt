package com.example.mvp_example

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun getLogin() : String
}