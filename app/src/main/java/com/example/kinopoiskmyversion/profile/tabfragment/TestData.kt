package com.example.kinopoiskmyversion.profile.tabfragment

import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData

object TestData {
    private val strangerThings = SavedCinemaData(
        8.374,
        915196,
        "Очень странные дела",
        2016,
        "Stranger Things",
        "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/4639b97f-1ff6-4f63-b7f6-02ea1a14f553/orig"
    )
    private val friends = SavedCinemaData(
        9.235,
        77044,
        "Друзья",
        1994,
        "Friends",
        "https://imagetmdb.com/t/p/original/l0qVZIpXtIo7km9u5Yqh0nKPOr5.jpg"
    )
    private val scrubs = SavedCinemaData(
        8.73,
        251568,
        "Клиника",
        2001,
        "Scrubs",
        "https://st.kp.yandex.net/images/film_big/251568.jpg"
    )
    private val andor = SavedCinemaData(
        8.116,
        1209850,
        "Андор",
        2022,
        "Andor",
        "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/487e1e3f-41fc-4dad-a715-4174b02c0d25/orig"
    )
    private val rogueOne = SavedCinemaData(
        7.249,
        840152,
        "Изгой-один: Звёздные войны. Истории",
        2016,
        "Rogue One",
        "https://imagetmdb.com/t/p/original/6t8ES1d12OzWyCGxBeDYLHoaDrT.jpg"
    )
    val seeLaterList: List<SavedCinemaData> =
        mutableListOf(
            scrubs, andor, friends, rogueOne, strangerThings
        )
    val seenList: List<SavedCinemaData> = mutableListOf(
        strangerThings, rogueOne, friends, scrubs, andor
    )
}