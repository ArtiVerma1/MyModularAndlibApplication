package com.example.mymodularandlibapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.calccmodule.model.DataItem
import com.example.mymodularandlibapplication.R

class UserAdapter (private val context: Context, private val data: List<DataItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var movies = mutableListOf<DataItem>()

    fun setMovieList(movies: List<DataItem>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(data[position]?.avatar)
            .into(holder.imageview)
        holder.name.setText(data[position].firstName)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview = itemView.findViewById(R.id.imageview) as ImageView
        var name = itemView.findViewById(R.id.name) as TextView
    }
}