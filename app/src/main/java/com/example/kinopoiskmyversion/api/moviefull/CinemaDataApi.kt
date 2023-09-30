package com.example.kinopoiskmyversion.api.moviefull

import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CinemaDataApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json",
        "X-API-KEY: J0M94EQ-MAGMZ2N-JEYB7A1-0J2QJ10" // так писать нельзя, потом узнать у киры, как надо писать
    )
    @GET(
        "/v1.3/movie/{id}"
    ) // любопытно как записывать id, так?
    fun getCinemaData(
        @Path("id") id: String
    ): Call<CinemaData>
}