package com.example.mvp_example.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class DefaultSchedulers : Schedulers {

    override fun background(): Scheduler = io.reactivex.schedulers.Schedulers.newThread()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}