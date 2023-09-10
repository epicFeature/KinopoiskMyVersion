package com.example.kinopoiskmyversion.movieinfo

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.moviefull.CinemaType
import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import com.example.kinopoiskmyversion.api.moviefull.models.Season
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.utils.toEnum

class CinemaDataMapper(
    private val binding: FragmentMovieBasicBinding,
    private val movieBasicFragment: MovieBasicFragment
) {

    fun toMovieBasicFragment(cinemaData: CinemaData){
        val currentType = cinemaData.type.replace("-","_").toEnum<CinemaType>() ?: CinemaType.UNKNOWN
        //основная часть mapping
        basicMapping(cinemaData)
        when (currentType.seasons) {
            true -> seriesMapping(cinemaData)
            false -> movieMapping(cinemaData)
            null -> nullCase(currentType,cinemaData)
        }
    }

    private fun basicMapping(cinemaData: CinemaData){
        with(binding) {
            titleRu.text = cinemaData.name
            titleEng.text = cinemaData.alternativeName
            rating.text = cinemaData.rating?.kp.toString()
            genresMapping(cinemaData)
            discription.text = cinemaData.description
        }
        Glide
            .with(movieBasicFragment)
            .load(cinemaData.poster.url)
            .centerCrop()
            .placeholder(R.drawable.background_gradient)
            .into(binding.poster)
    }



//кусок с сезонами и эпизодами надо делать через кастом вью, пока упрощенный вариант
//тут можно и лучше сделать, через использование нескольких constraint, но пока проверим на работоспособность простым путем

    private fun seriesMapping(cinemaData: CinemaData){
        with(binding) {
            seasonsText.text = "Сезоны: "
            seasonsNumber.text = cinemaData.seasonsInfo?.size.toString()
            episodesText.isVisible = true
            episodesNumber.isVisible = true
            episodesCount(cinemaData)
            airingMapping(cinemaData)
        }
    }

    private fun movieMapping(cinemaData: CinemaData){
        with(binding) {
            seasonsText.text = "Время: "
            seasonsNumber.text = cinemaData.movieLength.toString()
            episodesText.isVisible = false
            episodesNumber.isVisible = false
            airedData.text = cinemaData.year.toString()
        }
    }

    private fun nullCase(
        currentType: CinemaType,
        cinemaData: CinemaData
    ) {
        when (currentType) {
            CinemaType.UNKNOWN -> movieMapping(cinemaData) // потенциально может быть косяк, пока не пониманию может ли он быть в этой api
            CinemaType.ANIME -> animeMapping(cinemaData)
            else -> {} // можно ли оставлять такие заглушки?
        }
    }

    private fun animeMapping(cinemaData: CinemaData){
        if (!cinemaData.seasonsInfo.isNullOrEmpty()) seriesMapping(cinemaData)
        else movieMapping(cinemaData)
    }

    private fun episodesCount(cinemaData: CinemaData) {
        val episodesNumber = mutableListOf<Int>()
        cinemaData.seasonsInfo?.forEach {
            episodesNumber.add(it.episodesCount)
        }
        binding.episodesNumber.text = episodesNumber.sumOf { it }.toString()
    }

    private fun genresMapping(cinemaData: CinemaData) {
        val genreNames = mutableListOf<String>()
        cinemaData.genres.forEach {
            genreNames.add(it.name)
        }
        binding.genres.text = genreNames.joinToString(", ")
    }

    private fun airingMapping (cinemaData: CinemaData) {
        val airingPeriods = mutableListOf<String>()
        cinemaData.releaseYears?.forEach { airingPeriods.add("${it.start}-${it.end}") }
        binding.airedData.text = airingPeriods.joinToString ( ", " ) ?: "пока не известно"
    }
}