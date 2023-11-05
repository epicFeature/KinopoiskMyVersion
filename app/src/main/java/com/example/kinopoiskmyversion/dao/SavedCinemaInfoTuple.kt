package com.example.kinopoiskmyversion.dao

import androidx.room.ColumnInfo
import com.example.kinopoiskmyversion.api.moviefull.models.Genres
import com.example.kinopoiskmyversion.api.moviefull.models.Poster
import com.example.kinopoiskmyversion.api.moviefull.models.Season
import com.example.kinopoiskmyversion.api.moviefull.models.Years

data class SavedCinemaInfoTuple(
    @ColumnInfo(name = "movie_id") val movieId: Long,
    @ColumnInfo(name = "name_ru") val nameRu: String?,
    @ColumnInfo(name = "name_eng") val nameEng: String?,
    val year: Int?,
    @ColumnInfo(name = "release_years") val releaseYears: List<Years>?,
    val type: String?,
    @ColumnInfo(name = "movie_length") val movieLength: Int?,
    val genres: List<Genres>?,
    @ColumnInfo(name = "seasons_info") val seasonsInfo: List<Season>?,
    val description: String?,
    val poster: Poster,
    @ColumnInfo(name = "saved_see_later") val savedSeeLater: Boolean,
    @ColumnInfo(name = "saved_seen") val savedSeen: Boolean
)
