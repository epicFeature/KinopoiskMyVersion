package com.example.kinopoiskmyversion.api.search

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchData(
    val id: Int,
    val name: String,
    val enName: String,
    val year: Int,
    val poster: String,
    val rating: Double
)