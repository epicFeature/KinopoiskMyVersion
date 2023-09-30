package com.example.kinopoiskmyversion.movieinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.moviefull.GetCinemaService
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding
import com.example.kinopoiskmyversion.utils.KEY_MOVIE_ID


class MovieBasicFragment : Fragment() {

    private var _binding: FragmentMovieBasicBinding? = null
    private val binding get() = _binding!!

    private lateinit var cinemaId: String
    private lateinit var service: GetCinemaService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBasicBinding.inflate(inflater, container, false)
        arguments?.let {
            cinemaId = it.getString(KEY_MOVIE_ID)!!
        }
        service = GetCinemaService(cinemaId)
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


    }



