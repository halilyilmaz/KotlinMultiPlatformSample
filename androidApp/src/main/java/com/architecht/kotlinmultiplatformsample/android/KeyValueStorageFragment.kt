package com.architecht.kotlinmultiplatformsample.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.architecht.kotlinmultiplatformsample.storage.KeyValueStorageFactory
import com.russhwolf.settings.Settings
import kotlinx.android.synthetic.main.fragment_key_value_storage.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KeyValueStorageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KeyValueStorageFragment : Fragment() {
    lateinit var storage: Settings
    private val key = "key_123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_key_value_storage, container, false)
        storage = KeyValueStorageFactory(activity!!).createDriver()
        view.saveButton.setOnClickListener { view ->
            saveValue()
        }

        view.getValueButton.setOnClickListener { view ->
            getValue()
        }

        return view
    }

    private fun saveValue() {
        storage.putString(key, view?.txtValue?.text.toString())
    }

    private fun getValue() {
        val value = storage.getStringOrNull(key)
        if (value != null) {
            view?.txtGetValue?.text = value
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KeyValueStorageFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}