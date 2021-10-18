package com.example.mvp_example.scheduler

import io.reactivex.Scheduler


interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler

}