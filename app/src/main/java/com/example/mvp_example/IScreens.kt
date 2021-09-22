package com.example.mvp_example

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun userInfo(userName: String): Screen
}