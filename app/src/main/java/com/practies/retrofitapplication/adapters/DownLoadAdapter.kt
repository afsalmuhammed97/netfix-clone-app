package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.databinding.DownLoadsItemBinding

import com.practies.retrofitapplication.Result
class DownLoadAdapter ( ):RecyclerView.Adapter<DownLoadAdapter.MyHolder>() {
    class MyHolder(val binding: DownLoadsItemBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallBack=object :DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
          return newItem==oldItem
        }

    }
    val differ=AsyncListDiffer(this,diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownLoadAdapter.MyHolder {
       return MyHolder(DownLoadsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DownLoadAdapter.MyHolder, position: Int) {
      val movie=differ.currentList[position]

        Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ movie.poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            .centerCrop()
            .into(holder.binding.moviePoster)

        holder.binding.moveName.text=movie.title




    }

    override fun getItemCount()= differ.currentList.size
}