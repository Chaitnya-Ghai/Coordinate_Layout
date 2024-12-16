package com.example.medplus.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.medplus.MainActivity
import com.example.medplus.fragments.HomeFragment
import com.example.medplus.fragments.TodayOffer

class MainViewPagerAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {
    private val fragments = listOf(HomeFragment(), TodayOffer(),)

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}