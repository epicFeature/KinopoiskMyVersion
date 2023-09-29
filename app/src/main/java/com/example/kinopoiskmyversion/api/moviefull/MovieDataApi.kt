package com.example.kinopoiskmyversion.api.moviefull

import com.example.kinopoiskmyversion.api.moviefull.models.movie.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MovieDataApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json",
        "X-API-KEY: J0M94EQ-MAGMZ2N-JEYB7A1-0J2QJ10"
    )
    @GET(
        "/v1.3/movie/{id}"
    ) // любопытно как записывать id, так?
    fun getMovieData(
        @Path("id") id: String
    ): Call<MovieData>
}