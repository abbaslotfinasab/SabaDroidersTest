package com.example.data.repo

import com.example.data.api.Service
import com.example.data.utile.NetworkHelper
import com.example.domain.models.ItemModel
import com.example.domain.repositories.MovieListRepo
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieListRepoImpl @Inject constructor(

    private val service: Service,
    private val networkHelper: NetworkHelper

): MovieListRepo {

    override suspend fun getMovieList(query:String?): MutableList<ItemModel> {

        if (networkHelper.isNetworkConnected()) {

            val result = service.getMovies(query)

            return when (result.isSuccessful && result.body() != null) {

                true -> {
                    result.body()?.data?.map {
                        it.toDomain()
                    }?.toMutableList()?: emptyList<ItemModel>().toMutableList()
                }

                else ->
                    throw IOException("Server is Not Responding")
            }

        } else throw IOException("No Internet Connection")
    }
}