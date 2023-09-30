package com.example.kinopoiskmyversion.api.moviefull.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Poster(
    val url: String
)