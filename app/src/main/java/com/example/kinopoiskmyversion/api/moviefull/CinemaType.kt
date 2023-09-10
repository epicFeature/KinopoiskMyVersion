package com.example.kinopoiskmyversion.api.moviefull

enum class CinemaType(
    val type: String, val seasons: Boolean?, val dateRange: Boolean?
    ) {
    TV_SERIES("tv-series", true, true),
    MOVIE("movie", false, false),
    CARTOON("cartoon", false, false),
    ANIME("anime", null, null),
    ANIMATED_SERIES("animated-series", true, true),
    TV_SHOW("tv-show", true, true),
    UNKNOWN("unknown", null, null)
}

