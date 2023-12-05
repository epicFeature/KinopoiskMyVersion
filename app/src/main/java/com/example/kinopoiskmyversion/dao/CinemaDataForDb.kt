package com.example.kinopoiskmyversion.dao

import com.example.kinopoiskmyversion.api.moviefull.models.Genres
import com.example.kinopoiskmyversion.api.moviefull.models.Poster
import com.example.kinopoiskmyversion.api.moviefull.models.Season
import com.example.kinopoiskmyversion.api.moviefull.models.Years
import com.example.kinopoiskmyversion.dao.model.SavedCinemaDbEntity

data class CinemaDataForDb(
    val movieId: Long,
    val nameRu: String?,
    val nameEng: String?,
    val year: Int?,
    val releaseYears: List<Years>?,
    val type: String?,
    val movieLength: Int?,
    val genres: List<Genres>?,
    val seasonsInfo: List<Season>?,
    val description: String?,
    val poster: Poster,
    val savedSeeLater: Boolean,
    val savedSeen: Boolean
) {
    fun toSavedDbEntity(): SavedCinemaDbEntity = SavedCinemaDbEntity(
        movieId = movieId,
        nameRu = nameRu,
        nameEng = nameEng,
        year = year,
        releaseYears=releaseYears,
        type=type,
        movieLength=movieLength,
        genres=genres,
        seasonsInfo=seasonsInfo,
        description=description,
        poster=poster,
        savedSeeLater=savedSeeLater,
        savedSeen=savedSeen
    )
}


