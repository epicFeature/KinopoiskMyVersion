package com.example.kinopoiskmyversion.api.moviefull

import android.util.Log
import com.example.kinopoiskmyversion.api.common.RetrofitInstance
import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCinemaService(
    id: String
) {
    private val api: CinemaDataApi = RetrofitInstance.getCinemaDataApi

    fun injectCinemaData(id: String) =
        api.getCinemaData(id)
            .enqueue(object : Callback<CinemaData>{
                override fun onResponse(
                    call: Call<CinemaData>,
                    response: Response<CinemaData>
                ) {
                    when(response.code()){
                        200 -> mapCinemaDataToView(response.body()!!)
                        else -> Log.e("", "error GetMovieData for $id")
                    }
                }

                override fun onFailure(call: Call<CinemaData>, t: Throwable) {
                    Log.e("", t.message.toString())
                }
            })

    private fun mapCinemaDataToView(cinemaData: CinemaData) {
        TODO("Not yet implemented")
    }



}