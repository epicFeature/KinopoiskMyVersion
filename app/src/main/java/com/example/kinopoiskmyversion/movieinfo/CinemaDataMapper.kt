package com.example.kinopoiskmyversion.movieinfo

import com.example.kinopoiskmyversion.api.moviefull.CinemaType
import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.utils.toEnum

class CinemaDataMapper {
    fun toMovieBasicFragment (binding:FragmentMovieBasicBinding, cinemaData: CinemaData){
        with(binding){

        }
    }

    private fun mapCinemaDataToView(cinemaData: CinemaData) {
        val currentType = cinemaData.type.toEnum<CinemaType>() ?: CinemaType.UNKNOWN
    }
}