package com.example.kinopoiskmyversion.movieinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentMovieBasicBinding


class MovieBasicFragment : Fragment() {

    private var _binding: FragmentMovieBasicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBasicBinding.inflate(inflater, container, false)
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