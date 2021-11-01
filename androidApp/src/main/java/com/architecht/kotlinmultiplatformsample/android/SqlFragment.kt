package com.architecht.kotlinmultiplatformsample.android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.architecht.kotlinmultiplatformsample.repository.DatabaseDriverFactory
import com.architecht.kotlinmultiplatformsample.repository.MembersRepository
import com.architecht.kotlinmultiplatformsample.storage.KeyValueStorageFactory
import kotlinx.android.synthetic.main.fragment_sql.view.*

class SqlFragment : Fragment() {
    private lateinit var db: MembersRepository
    private val usersAdapter = SqlRecyclerViewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sql, container, false)
        view.sqlRecyclerView.adapter = usersAdapter
        view.sqlRecyclerView.layoutManager = LinearLayoutManager(activity)

        db = MembersRepository(DatabaseDriverFactory(activity!!))
        view.insertButton.setOnClickListener { view ->
            Log.d("Insert Button", "tapped")
            insertUser()
        }

        view.fetchButton.setOnClickListener { view ->
            fetchUsers()
        }
        return view
    }

    private fun insertUser() {
        val username = view?.txtUserName?.text.toString()
        val lastname = view?.txtLastName?.editText?.text.toString()
        db.insertUser(username, lastname)
        fetchUsers()
    }

    private fun fetchUsers() {
        Toast.makeText(activity!!, "Test", Toast.LENGTH_LONG)
        val users = db.selectAllUsers()
        usersAdapter.users = users
        usersAdapter.notifyDataSetChanged()

        // val test = KeyValueStorage(context!!)
        // test.set(23)

        val storage = KeyValueStorageFactory(activity!!)
        val driver = storage.createDriver()
        driver.putDouble("key123", 1234.23)
        driver.getBooleanOrNull("test")

        Log.d("TEST", "" + driver.getDoubleOrNull("key123").toString())
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SqlFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}