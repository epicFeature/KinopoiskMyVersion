package com.example.kinopoiskmyversion.api.search

import com.example.kinopoiskmyversion.api.common.RetrofitInstance

class  GetSearchService {
    private val api: SearchDataApi = RetrofitInstance.getsearchMovieDataApi

    fun getSearchData(searchText: String) =
        api.getSearchData(searchText)
}