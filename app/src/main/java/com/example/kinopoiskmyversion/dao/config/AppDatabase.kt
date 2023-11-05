package com.example.kinopoiskmyversion.dao.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kinopoiskmyversion.dao.model.SavedCinemaEntity
import com.example.kinopoiskmyversion.dao.repository.SavedCinemaDao

@Database(
    version = 1,
    entities = [SavedCinemaEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getSavedCinemaDao(): SavedCinemaDao
}