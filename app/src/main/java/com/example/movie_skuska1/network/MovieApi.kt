package com.example.movie_skuska1.network

import com.example.movie_skuska1.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
        @GET("popular?")
        fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>

}