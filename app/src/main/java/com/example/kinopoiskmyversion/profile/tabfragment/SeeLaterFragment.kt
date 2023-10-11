package com.example.kinopoiskmyversion.profile.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentProfileBinding
import com.example.kinopoiskmyversion.databinding.FragmentSeeLaterBinding


class SeeLaterFragment : Fragment() {

    private var _binding: FragmentSeeLaterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeeLaterBinding.inflate(inflater, container, false)
        return binding.root
    }

}