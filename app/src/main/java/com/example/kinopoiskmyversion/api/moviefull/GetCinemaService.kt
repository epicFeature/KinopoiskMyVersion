package com.example.kinopoiskmyversion.api.moviefull

import android.util.Log
import androidx.core.view.isVisible
import com.example.kinopoiskmyversion.api.common.RetrofitInstance
import com.example.kinopoiskmyversion.api.moviefull.models.CinemaData
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.utils.toEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GetCinemaService(
    id: String,
    private val injectCinemaData: (CinemaData) -> Unit
) {
    private val api: CinemaDataApi = RetrofitInstance.getCinemaDataApi

    fun injectCinemaData(id: String) =
        api.getCinemaData(id)
            .enqueue(object : Callback<CinemaData> {
                override fun onResponse(
                    call: Call<CinemaData>,
                    response: Response<CinemaData>
                ) {
                    when (response.code()) {
                        200 -> mapCinemaDataToView(response.body()!!)
                        else -> Log.e("", "error GetMovieData for $id")
                    }
                }

                override fun onFailure(call: Call<CinemaData>, t: Throwable) {
                    Log.e("", t.message.toString())
                }
            })



}