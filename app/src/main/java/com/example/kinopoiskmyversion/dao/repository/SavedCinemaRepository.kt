package com.example.kinopoiskmyversion.dao.repository

import com.example.kinopoiskmyversion.dao.SavedCinemaInfoTuple
import com.example.kinopoiskmyversion.dao.model.SavedCinemaDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedCinemaRepository(private val savedCinemaDao: SavedCinemaDao) {
    suspend fun insertNewSavedCinemaData(savedCinemaDbEntity: SavedCinemaDbEntity) {
        withContext(Dispatchers.IO) {
            savedCinemaDao.insertNewSavedCinemaData(savedCinemaDbEntity)
        }
    }

    suspend fun getAllSavedCinemaData(): List<SavedCinemaInfoTuple> {
        return withContext(Dispatchers.IO) {
            savedCinemaDao.getAllSavedCinemaData()
        }
    }

    suspend fun deleteSavedCinemaDataByIt(cinemaDataId: Long) {
        withContext(Dispatchers.IO){
            savedCinemaDao.deleteSavedCinemaDataById(cinemaDataId)
        }
    }

    suspend fun changeSeeLaterState(seeLaterState: Boolean) {
        withContext(Dispatchers.IO){
            savedCinemaDao.changeSeeLaterState(seeLaterState)
        }
    }

    suspend fun changeSeenState(seenState: Boolean) {
        withContext(Dispatchers.IO){
            savedCinemaDao.changeSeenState(seenState)
        }
    }
}