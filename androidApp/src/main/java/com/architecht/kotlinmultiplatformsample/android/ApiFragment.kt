package com.architecht.kotlinmultiplatformsample.android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architecht.kotlinmultiplatformsample.api.CoinstatsAPI
import kotlinx.android.synthetic.main.fragment_api.*
import kotlinx.android.synthetic.main.fragment_api.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ApiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ApiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val coinsAdapter = CoinRecyclerviewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_api, container, false)
        view.coinsRecyclerView.adapter = coinsAdapter
        view.coinsRecyclerView.layoutManager = LinearLayoutManager(activity)

        view.fetchButton.setOnClickListener { view ->
            fetchCoins()
            Log.d("Clicked", "test")
        }

        fetchCoins()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ApiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun fetchCoins() {
        val api = CoinstatsAPI()

        api.fetchCoins(success = {
            print("COINS " + it.coins.toString())
            activity?.runOnUiThread {
                coinsAdapter.coins = it.coins
                coinsAdapter.notifyDataSetChanged()
            }
        }, failure = {
            print("FAILURE " + it.toString())
        })
    }
}