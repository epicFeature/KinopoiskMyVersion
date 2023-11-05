package com.example.kinopoiskmyversion.dao.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kinopoiskmyversion.dao.SavedCinemaInfoTuple
import com.example.kinopoiskmyversion.dao.model.SavedCinemaEntity

@Dao
interface SavedCinemaDao {
    @Insert(entity = SavedCinemaEntity::class)
    fun insertNewCinemaData(savedCinema: SavedCinemaEntity)

    @Query(
        "SELECT movie_id, name_ru, name_eng, year, release_years, " +
                "type, movie_length, genres, seasons_info, description, " +
                "poster, saved_see_later, saved_seen " +
                "FROM saved_cinema_data"
    )
    fun getAllStatisticData(): List<SavedCinemaInfoTuple>

    @Query("DELETE FROM saved_cinema_data " +
            "WHERE movie_id = :cinemaDataId")
    fun deleteStatisticDataById(cinemaDataId: Long)

    @Update(
        entity = SavedCinemaEntity::class
    )
    fun changeSeeLaterState(seeLaterState:Boolean) // не уверена, нужно проверить

    @Update(
        entity = SavedCinemaEntity::class
    )
    fun changeSeenState(seenState: Boolean)// то же самое
}