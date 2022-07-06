package com.example.domain.usecases

import com.example.domain.models.ItemModel
import com.example.domain.repositories.MovieListRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieListUseCaseImpl @Inject constructor(private val movieListRepo: MovieListRepo):
    MovieListUseCase<ItemModel> {

    override suspend fun execute(query: String?): MutableList<ItemModel> {
        return movieListRepo.getMovieList(query)
    }
}