package com.example.kinopoiskmyversion.api.moviefull.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CinemaData(
    val rating: Rating,
    val id:Int,
    val description: String,
    val name: String,
    val year: Int,
    val genres:List<Genres>,
    val type:String,
    val alternativeName:String,
    val seasonsInfor:List<Season>?,
    val releaseYear:List<Years>?,
    val poster: Poster
)
