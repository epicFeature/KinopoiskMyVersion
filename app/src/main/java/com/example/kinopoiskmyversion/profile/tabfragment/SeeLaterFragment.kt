package com.example.kinopoiskmyversion.profile.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentSeeLaterBinding
import com.example.kinopoiskmyversion.utils.KEY_MOVIE_ID


class SeeLaterFragment : Fragment() {
    private lateinit var adapter: TabRecyclerViewAdapter

    private var _binding: FragmentSeeLaterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeeLaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //services
        adapter = TabRecyclerViewAdapter{onClick(it)} // как компилятор понял, что it то cinema data
        binding.seeLaterRecyclerView.layoutManager = LinearLayoutManager(this.requireContext().applicationContext)
        binding.seeLaterRecyclerView.adapter = adapter

        adapter.data = TestData.seeLaterList
    }

    private fun onClick(savedCinemaData: SavedCinemaData){
        val bundle = Bundle()
        bundle.putString(
            KEY_MOVIE_ID,
            savedCinemaData.id.toString()
        )
        findNavController().navigate(
            R.id.action_profileFragment_to_movieBasicFragment,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}