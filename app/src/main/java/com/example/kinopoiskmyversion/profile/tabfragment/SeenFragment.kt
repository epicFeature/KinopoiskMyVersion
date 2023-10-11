package com.example.kinopoiskmyversion.profile.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentSeeLaterBinding
import com.example.kinopoiskmyversion.databinding.FragmentSeenBinding

class SeenFragment : Fragment() {

    private var _binding: FragmentSeenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeenBinding.inflate(inflater, container, false)
        return binding.root
    }

}