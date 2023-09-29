package com.example.kinopoiskmyversion.api.search

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchData(
    val docs: List<Data>
)

@JsonClass(generateAdapter = true)
data class Data(
    val id: Int,
    val name: String,
    val alternativeName: String,
    val year: Int,
    val poster: String?,
    val rating: Double
)