package com.example.kinopoiskmyversion.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

        initializeTab()

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

    // возможно эту функцию стоит запихнуть в сервис и тут инициализировать лямбду
    private fun initializeTab(){
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos ->
            when(pos){
                0-> {
                    tab.setIcon(R.drawable.bookmark_icon)
                    tab.icon?.setTint(ContextCompat.getColor(this.requireContext(), R.color.orange_700))
                }
                1-> {
                    tab.setIcon(R.drawable.seen_icon)
                    tab.icon?.setTint(ContextCompat.getColor(this.requireContext(),R.color.black))
                    tab.icon?.alpha = 70
                }
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.setTint(ContextCompat.getColor(requireContext(),R.color.orange_700))
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setTint(ContextCompat.getColor(requireContext(),R.color.black)) // почему там this.requireContext, а тут он сам понимает какой контекст?
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // Use the ViewModel
    }*/

}