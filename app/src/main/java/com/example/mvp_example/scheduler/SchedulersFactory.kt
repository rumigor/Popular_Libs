package com.example.mvp_example.scheduler

import ru.rumigor.jpgtopng.scheduler.DefaultSchedulers

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}