package com.example.mvp_example.data.di

import javax.inject.Qualifier

@Qualifier
annotation class Cloud

@Qualifier
annotation class Cache

@Qualifier
annotation class InMemory

@Qualifier
annotation class Persisted