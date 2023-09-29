package com.example.kinopoiskmyversion.movieinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.moviefull.GetMovieService
import com.example.kinopoiskmyversion.api.moviefull.models.movie.MovieData
import com.example.kinopoiskmyversion.api.moviefull.models.series.SeriesData
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.utils.KEY_MOVIE_ID


class MovieBasicFragment : Fragment() {

    private var _binding: FragmentMovieBasicBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieId: String
    private lateinit var service: GetMovieService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBasicBinding.inflate(inflater, container, false)
        arguments?.let {
            movieId = it.getString(KEY_MOVIE_ID)!!
        }
        service = GetMovieService()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profileNavButton -> findNavController().navigate(R.id.action_movieBasicFragment_to_profileFragment)
                R.id.searchNavButton -> findNavController().navigate(R.id.action_movieBasicFragment_to_mainFragment)
                else -> {
                }
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun injectMovieData(movieData: MovieData){
        with(binding){

        }
    }

    private fun injectSeriesData(seriesData: SeriesData){

    }

}