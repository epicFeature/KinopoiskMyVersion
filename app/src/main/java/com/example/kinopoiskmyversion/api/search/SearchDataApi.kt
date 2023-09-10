package com.example.kinopoiskmyversion.api.search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchDataApi {

    @Headers(
        "Accept: application/json",
        "Content-type: application/json",
        "X-API-KEY: J0M94EQ-MAGMZ2N-JEYB7A1-0J2QJ10"
    )
    @GET(
        "/v1.2/movie/search?page=1&limit=10"
    )//гет запрос для поиска текста, после query должен быть переделанный текст
    fun getSearchData(@Query("query") searchText: String): Call<SearchData>//тут где-то должен подключаться recycleView
    //поч саспенд?

}