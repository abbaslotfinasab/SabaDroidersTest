package com.example.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.ItemModel


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var movieList: MutableList<ItemModel> = mutableListOf()


    fun addData(_movies:MutableList<ItemModel>) {
        movieList.clear()
        notifyDataSetChanged()
        movieList.addAll(_movies)
        notifyItemRangeChanged(0,movieList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind0(position)
    }

    override fun getItemCount(): Int = movieList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.title)
        private val rate: TextView = itemView.findViewById(R.id.rate)
        private val image: ImageView = itemView.findViewById(R.id.imageView)



        fun bind0(position: Int) {

            if (movieList[position].attributes?.movie_title_en?.isNotEmpty() == true){
                name.text = movieList[position].attributes?.movie_title_en
            }else{
                name.text = movieList[position].attributes?.movie_title
            }

            rate.text = movieList[position].attributes?.rate_avrage

            Glide.with(itemView.context)
                .load(movieList[position].attributes?.photo)
                .into(image)
        }
    }
}

