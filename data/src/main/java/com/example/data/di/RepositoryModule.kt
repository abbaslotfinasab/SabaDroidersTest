package com.example.data.di

import com.example.data.repo.MovieListRepoImpl
import com.example.domain.repositories.MovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCryptoCurrencyRepositoryService(
        movieListRepoImpl: MovieListRepoImpl
    ): MovieListRepo
}
