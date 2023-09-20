package com.example.kinopoiskmyversion.api.search

import com.example.kinopoiskmyversion.api.common.RetrofitInstance

class GetSearchService {
    private val api: SearchDataApi = RetrofitInstance.searchMovieData

    fun injectSearchData() = api.getSearchData()
}