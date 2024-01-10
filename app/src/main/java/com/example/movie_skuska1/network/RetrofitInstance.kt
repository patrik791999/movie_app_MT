package com.example.movie_skuska1.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

//builder pattern of retrofit for set base URL, use Gson Converter for convert data from JSON to Kotlin data class and create api interface
object RetrofitInstance {
    val api : MovieApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}