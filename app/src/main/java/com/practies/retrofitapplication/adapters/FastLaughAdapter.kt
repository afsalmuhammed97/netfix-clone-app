package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.databinding.FastLaughItemBinding
import com.practies.retrofitapplication.Result
//val posterList:List<com.practies.retrofitapplication.Result>
class FastLaughAdapter ():RecyclerView.Adapter< FastLaughAdapter.MyHolder>() {
    class MyHolder(val binding: FastLaughItemBinding) : RecyclerView.ViewHolder(binding.root)

 private val diffCallback=object :DiffUtil.ItemCallback<Result>(){
     override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id==newItem.id
     }

     override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return newItem==oldItem
     }

 }
    val differ=AsyncListDiffer(this,diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastLaughAdapter.MyHolder {
        return MyHolder(FastLaughItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FastLaughAdapter.MyHolder, position: Int) {
        //  holder.binding.moviePoster.setImageResource()

        // Glide.with(holder.itemView.context).load( "http://image.tmdb.org/t/p/w500${posterList[position].poster_path})
                 val movie=differ.currentList[position]
        Glide.with(holder.itemView.context)
            .load("http://image.tmdb.org/t/p/w500${movie.poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            .centerCrop()
            .into(holder.binding.moviePoster)
    }

    override fun getItemCount() = differ.currentList.size


}