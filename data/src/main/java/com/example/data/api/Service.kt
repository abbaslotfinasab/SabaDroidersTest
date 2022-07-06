package com.example.data.api

import com.example.data.entity.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("en/v1/movie/movie/list/tagid/1000300/text/{Query}/sug/on")
    suspend fun getMovies(@Path("Query")query:String?=""): Response<Data>

}