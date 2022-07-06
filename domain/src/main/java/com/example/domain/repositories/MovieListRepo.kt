package com.example.domain.repositories

import com.example.domain.models.ItemModel

interface MovieListRepo {

    suspend fun getMovieList(query:String?=""):MutableList<ItemModel>

}