package com.example.kinopoiskmyversion.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kinopoiskmyversion.ui.profile.tabfragment.SeeLaterFragment
import com.example.kinopoiskmyversion.ui.profile.tabfragment.SeenFragment

class PagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) { //поч тут используется fragment activity
    override fun getItemCount() = 2 // хардкод тк фиксированное число

    override fun createFragment(position: Int): Fragment {
        return if (position==0)
            SeeLaterFragment()
         else SeenFragment()
    }

}