package com.example.marmeladetest.di

import com.example.marmeladetest.network.MarmeladeApi
import dagger.Provides
import javax.inject.Singleton

object RepoModule {
    @Singleton
    @Provides
    fun provideWebService() = MarmeladeApi()

}