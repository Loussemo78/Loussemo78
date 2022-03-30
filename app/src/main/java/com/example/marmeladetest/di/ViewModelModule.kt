package com.example.marmeladetest.di

import com.example.marmeladetest.repository.QuoteRepository
import com.example.marmeladetest.repository.QuoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: QuoteRepositoryImpl): QuoteRepository
}