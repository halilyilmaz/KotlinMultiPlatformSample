package com.architecht.kotlinmultiplatformsample.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coinview.view.*
import model.Coin

class CoinRecyclerviewAdapter(var coins: List<Coin>):
    RecyclerView.Adapter<CoinRecyclerviewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.coinview, parent, false)
            .run(::Holder)
    }

    override fun getItemCount(): Int {
        return coins.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(coins[position])
    }

    inner class Holder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            print("ON CLICKED")
        }

        fun bind(item: Coin) {
            view.textView.text = item.name
            view.priceTV.text = "$" + item.price
            Picasso.get()
                .load(item.icon)
                .into(view.imageView)
        }
    }
}

