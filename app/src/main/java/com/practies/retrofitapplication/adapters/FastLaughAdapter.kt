package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.databinding.FastLaughItemBinding
import javax.xml.transform.Result

class FastLaughAdapter (val posterList:List<com.practies.retrofitapplication.Result>):RecyclerView.Adapter< FastLaughAdapter.MyHolder>() {
    class MyHolder(val binding: FastLaughItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastLaughAdapter.MyHolder {
        return MyHolder(FastLaughItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FastLaughAdapter.MyHolder, position: Int) {
        //  holder.binding.moviePoster.setImageResource()

        // Glide.with(holder.itemView.context).load( "http://image.tmdb.org/t/p/w500${posterList[position].poster_path})

        Glide.with(holder.itemView.context)
            .load("http://image.tmdb.org/t/p/w500${posterList[position].poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            .centerCrop()
            .into(holder.binding.moviePoster)
    }

    override fun getItemCount() = posterList.size


}