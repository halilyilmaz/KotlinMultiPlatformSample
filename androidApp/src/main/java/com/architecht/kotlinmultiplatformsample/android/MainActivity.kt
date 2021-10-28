package com.architecht.kotlinmultiplatformsample.android

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.architecht.kotlinmultiplatformsample.Greeting
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architecht.kotlinmultiplatformsample.api.CoinstatsAPI
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var coinsRecyclerView: RecyclerView
    private val coinsAdapter = CoinRecyclerviewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.tabMode = TabLayout.MODE_FIXED
        tab_layout.isInlineLabel = true
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this,android.R.color.white)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)

        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs = 3)
        tabs_viewpager.adapter = adapter
        tabs_viewpager.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "API"
                    tab.setIcon(R.drawable.abc_vector_test)
                }
                1 -> {
                    tab.text = "SqlDelight"
                    tab.setIcon(R.drawable.abc_vector_test)
                }
                2 -> {
                    tab.text = "SharedPref"
                    tab.setIcon(R.drawable.abc_vector_test)
                }
            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()

        setCustomTabTitles()

        /*
        coinsRecyclerView = findViewById(R.id.recyclerview)
        coinsRecyclerView.adapter = coinsAdapter
        coinsRecyclerView.layoutManager = LinearLayoutManager(this)
        fetchCoins()
         */
    }

    fun fetchCoins() {
        val api = CoinstatsAPI()
        /*
        api.fetchCoins(success = {
            print("COINS " + it.coins.toString())
            runOnUiThread {
                coinsAdapter.coins = it.coins
                coinsAdapter.notifyDataSetChanged()
            }
        }, failure = {
            print("FAILURE " + it.toString())
        })

         */
    }

    private fun setCustomTabTitles() {
        val vg = tab_layout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount

        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup

            val tabChildCount = vgTab.childCount

            for (i in 0 until tabChildCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.typeface = Typeface.DEFAULT_BOLD
                }
            }
        }
    }
}
