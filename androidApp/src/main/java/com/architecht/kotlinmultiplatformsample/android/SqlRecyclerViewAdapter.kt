package com.architecht.kotlinmultiplatformsample.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architecht.db.User
import kotlinx.android.synthetic.main.coinview.view.*
import kotlinx.android.synthetic.main.fragment_sql.view.*
import kotlinx.android.synthetic.main.userview.view.*

class SqlRecyclerViewAdapter(var users: List<User>): RecyclerView.Adapter<SqlRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.userview, parent, false)
            .run(::Holder)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    inner class Holder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            print("ON CLICKED")
        }

        fun bind(item: User) {
            view.txtUser.text = item.name
            view.txtLast.text = item.last_name
        }
    }

}