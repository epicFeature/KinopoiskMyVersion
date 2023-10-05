package com.example.kinopoiskmyversion.api.moviefull

import android.util.Log
import androidx.core.view.isVisible
import com.example.kinopoiskmyversion.api.common.RetrofitInstance
import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.movieinfo.CinemaDataMapper
import com.example.kinopoiskmyversion.movieinfo.MovieBasicFragment
import com.example.kinopoiskmyversion.utils.toEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GetCinemaService(
    private val injectCinemaData: (CinemaData) -> Unit
) {
    private val api: CinemaDataApi = RetrofitInstance.getCinemaDataApi


    fun getCinemaData(id: String) =
        api.getCinemaData(id)
            .enqueue(object : Callback<CinemaData> {
                override fun onResponse(
                    call: Call<CinemaData>,
                    response: Response<CinemaData>
                ) {
                    when (response.code()) {
                        200 -> injectCinemaData(response.body()!!)
                        // mapCinemaDataToView(response.body()!!)
                        else -> Log.e("", "error GetMovieData for $id")
                    }
                }

                override fun onFailure(call: Call<CinemaData>, t: Throwable) {
                    Log.e("", t.message.toString())
                }
            })



}