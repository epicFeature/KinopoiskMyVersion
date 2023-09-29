package com.example.kinopoiskmyversion.api.common

import com.example.kinopoiskmyversion.api.moviefull.MovieDataApi
import com.example.kinopoiskmyversion.api.search.SearchDataApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.kinopoisk.dev"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create()
        )
        .build()

    val getsearchMovieDataApi: SearchDataApi = retrofit.create(SearchDataApi::class.java)
    // тут точно так же будут переменные для др экранов
    val getMovieDataApi: MovieDataApi = retrofit.create(MovieDataApi::class.java)
}