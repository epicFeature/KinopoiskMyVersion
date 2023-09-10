package com.example.kinopoiskmyversion.api.moviefull.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Years(
    val start: Int,
    val end: Int?
)