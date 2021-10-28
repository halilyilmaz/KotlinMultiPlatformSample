package com.architecht.kotlinmultiplatformsample.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int): FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "API")
                val apiFragment = ApiFragment()
                apiFragment.arguments = bundle
                return apiFragment
            }

            1 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "SqlDelight")
                val apiFragment = SqlFragment()
                apiFragment.arguments = bundle
                return apiFragment
            }

            2 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "SharedPref")
                val apiFragment = ApiFragment()
                apiFragment.arguments = bundle
                return apiFragment
            }
            else -> return ApiFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}