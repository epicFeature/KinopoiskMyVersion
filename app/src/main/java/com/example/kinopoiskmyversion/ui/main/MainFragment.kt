package com.example.kinopoiskmyversion.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.search.Data
import com.example.kinopoiskmyversion.api.search.GetSearchService
import com.example.kinopoiskmyversion.api.search.SearchData
import com.example.kinopoiskmyversion.databinding.FragmentMainBinding
import com.example.kinopoiskmyversion.utils.KEY_MOVIE_ID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var getSearchService: GetSearchService
    private lateinit var adapter: SearchRecycleViewAdapter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    /*private lateinit var viewModel: MainViewModel*/

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Use the ViewModel
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //services
        getSearchService = GetSearchService()
        adapter = SearchRecycleViewAdapter { onClick(it) }
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(this.requireContext().applicationContext)
        binding.searchRecyclerView.adapter = adapter

        binding.search.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                if (text != null) {
                    getSearchService.getSearchData(text)
                        .enqueue(object : Callback<SearchData> {
                            override fun onResponse(
                                call: Call<SearchData>,
                                response: Response<SearchData>
                            ) {
                                when (response.code()) {
                                    200 -> adapter.data = response.body()?.docs
                                        ?: emptyList() // стопорнулась на адаптере
                                    else -> Log.d("", "")
                                }
                            }

                            override fun onFailure(call: Call<SearchData>, t: Throwable) {
                                Log.e("OOps", t.message.toString())
                            }

                        })
                } else return true
                return true
            }

            override fun onQueryTextChange(newText: String?) = true
        })

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profileNavButton -> {
                    findNavController().navigate(R.id.action_mainFragment_to_profileFragment)
                    true
                }
                R.id.currentMovieNavButton -> {
                    findNavController().navigate(R.id.action_mainFragment_to_movieBasicFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun onClick(data: Data) {
        val bundle = Bundle()
        bundle.putString(
            KEY_MOVIE_ID,
            data.id.toString()
        )
        findNavController().navigate(
            R.id.action_mainFragment_to_movieBasicFragment,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}