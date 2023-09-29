package com.example.kinopoiskmyversion.api.moviefull.models.movie

import com.example.kinopoiskmyversion.api.moviefull.models.Genres
import com.example.kinopoiskmyversion.api.moviefull.models.Poster
import com.example.kinopoiskmyversion.api.moviefull.models.Rating
import com.example.kinopoiskmyversion.api.moviefull.models.Years

data class MovieData(
    val rating: Rating,
    val id:Int,
    val description: String,
    val name: String,
    val year: Int,
    val genres:List<Genres>,
    val type:String,
    val alternativeName:String,
    val poster: Poster
)
