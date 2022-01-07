package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.databinding.ComingSoonItemBinding

class ComingSoonPageAdapter(val upComingMovies: List<Result> ):RecyclerView.Adapter<ComingSoonPageAdapter.MyHolder>() {
    class MyHolder (val binding: ComingSoonItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return  upComingMovies.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        return MyHolder(ComingSoonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val movie=upComingMovies[position]
       Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ upComingMovies[position].poster_path}")
           .apply(RequestOptions.placeholderOf(R.drawable.music1))
           //.centerCrop()
          .centerInside()
           .into(holder.binding.moviePoster)

        holder.binding.movieName.text=movie.title
        holder.binding.discription.text=movie.overview
        holder.binding.releaseDateText.text=movie.release_date
    }




}