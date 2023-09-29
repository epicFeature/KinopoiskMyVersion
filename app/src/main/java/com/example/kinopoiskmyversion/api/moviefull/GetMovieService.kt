package com.example.kinopoiskmyversion.api.moviefull

import android.util.Log
import com.example.kinopoiskmyversion.api.common.RetrofitInstance
import com.example.kinopoiskmyversion.api.moviefull.models.movie.MovieData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMovieService(
    private val injectMovie: (MovieData) -> Unit
) {
    private val api: MovieDataApi = RetrofitInstance.getMovieDataApi

    fun injectMovie(id: String) =
        api.getMovieData(id)
            .enqueue(object : Callback<MovieData>{
                override fun onResponse(
                    call: Call<MovieData>,
                    response: Response<MovieData>
                ) {
                    when(response.code()){
                        200 -> injectMovie(response.body()!!)
                        else -> Log.e("", "error GetMovieData for $id")
                    }
                }

                override fun onFailure(call: Call<MovieData>, t: Throwable) {
                    Log.e("", t.message.toString())
                }
            })

}