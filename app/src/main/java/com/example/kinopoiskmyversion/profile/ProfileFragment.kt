package com.example.kinopoiskmyversion.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentMainBinding
import com.example.kinopoiskmyversion.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    /*private lateinit var viewModel: ProfileViewModel*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.searchNavButton -> findNavController().navigate(R.id.action_profileFragment_to_mainFragment)
                R.id.currentMovieNavButton -> findNavController().navigate(R.id.action_profileFragment_to_movieBasicFragment)
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

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // Use the ViewModel
    }*/

}