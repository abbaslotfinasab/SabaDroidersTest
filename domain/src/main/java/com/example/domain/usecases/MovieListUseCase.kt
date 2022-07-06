package com.example.domain.usecases

interface MovieListUseCase<R> {

    suspend fun execute(query:String?=""):MutableList<R>

}