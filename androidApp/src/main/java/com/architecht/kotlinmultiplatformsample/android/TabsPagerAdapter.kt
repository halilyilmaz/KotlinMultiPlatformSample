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
                val apiFragment = ApiFragment()
                apiFragment.arguments = bundle
                return apiFragment
            }

            1 -> {
                val bundle = Bundle()
                val sqlFragment = SqlFragment()
                sqlFragment.arguments = bundle
                return sqlFragment
            }

            2 -> {
                val bundle = Bundle()
                val keyStorageFragment = KeyValueStorageFragment()
                keyStorageFragment.arguments = bundle
                return keyStorageFragment
            }
            else -> return ApiFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}