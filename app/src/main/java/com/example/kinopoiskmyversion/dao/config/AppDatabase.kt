package com.example.kinopoiskmyversion.dao.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kinopoiskmyversion.dao.model.SavedCinemaDbEntity
import com.example.kinopoiskmyversion.dao.repository.SavedCinemaDao

@Database(
    version = 1,
    entities = [SavedCinemaDbEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getSavedCinemaDao(): SavedCinemaDao
}