package com.example.kinopoiskmyversion.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.kinopoiskmyversion.api.moviefull.models.Genres
import com.example.kinopoiskmyversion.api.moviefull.models.Poster
import com.example.kinopoiskmyversion.api.moviefull.models.Season
import com.example.kinopoiskmyversion.api.moviefull.models.Years

@Entity(
    tableName = "saved_cinema_data",
    indices = [Index("movie_id")],
)
data class SavedCinemaDbEntity(
    @PrimaryKey
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

