package com.example.kinopoiskmyversion.dao

import android.content.Context
import androidx.room.Room
import com.example.kinopoiskmyversion.dao.config.AppDatabase

object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context){
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "database.db"
        )
            .createFromAsset("example_cinema_data.db") // этот метод заполняет базу заранее заготовленными значениями
            .build()
    }
}