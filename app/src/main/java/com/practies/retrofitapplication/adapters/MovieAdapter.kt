package com.practies.retrofitapplication.adapters

import android.renderscript.Type
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.MovieResult
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.databinding.MovieViewBinding
import com.practies.retrofitapplication.databinding.SampleViewBinding

//List<MovieResult>  ( val movieList:List<MovieResult>)
class MovieAdapter(var movies: List<Result> ) :RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(val binding:MovieViewBinding):RecyclerView.ViewHolder(binding.root)

//

    override fun getItemCount()=movies.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieHolder {

       return MovieHolder(MovieViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieHolder, position: Int) {

     //   val url="http://image.tmdb.org/t/p/w500/+${ movies[position].poster_path}"
         Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ movies[position].poster_path}")
             .apply(RequestOptions.placeholderOf(R.drawable.music1))
             .centerCrop()
             .into(holder.binding.movieImage1)





    }

//    private val diffCallBack=object :DiffUtil.ItemCallback<MovieResult>(){
//
//        override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
//            return oldItem.poster_path==newItem.poster_path
//        }
//
//        override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
//            return  oldItem==newItem
//        }
//
//}






}