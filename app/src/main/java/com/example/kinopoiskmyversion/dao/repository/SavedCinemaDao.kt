package com.example.kinopoiskmyversion.dao.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kinopoiskmyversion.dao.SavedCinemaInfoTuple
import com.example.kinopoiskmyversion.dao.model.SavedCinemaDbEntity

@Dao
interface SavedCinemaDao {
    @Insert(entity = SavedCinemaDbEntity::class)
    fun insertNewSavedCinemaData(savedCinema: SavedCinemaDbEntity)

    @Query(
        "SELECT movie_id, name_ru, name_eng, year, release_years, " +
                "type, movie_length, genres, seasons_info, description, " +
                "poster, saved_see_later, saved_seen " +
                "FROM saved_cinema_data"
    )
    fun getAllSavedCinemaData(): List<SavedCinemaInfoTuple>

    @Query(
        "DELETE FROM saved_cinema_data " +
                "WHERE movie_id = :cinemaDataId"
    )
    fun deleteSavedCinemaDataById(cinemaDataId: Long)

    @Update(
        entity = SavedCinemaDbEntity::class
    )
    fun changeSeeLaterState(seeLaterState: Boolean) // не уверена, нужно проверить

    @Update(
        entity = SavedCinemaDbEntity::class
    )
    fun changeSeenState(seenState: Boolean)// то же самое
}