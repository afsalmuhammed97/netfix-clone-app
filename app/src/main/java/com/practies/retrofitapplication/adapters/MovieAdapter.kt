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

//   (var movies: List<Result> )
class MovieAdapter :RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(val binding:MovieViewBinding):RecyclerView.ViewHolder(binding.root)

private val diffCallback = object :DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {

    return  oldItem.id==newItem.id

    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
    return newItem ==oldItem
    }

}

    val   differ=AsyncListDiffer(this,diffCallback)

//    var movies:List<Result>
//    get() = differ.currentList
//          set(value) {
//              differ.submitList(value)
//          }

    override fun getItemCount()=differ.currentList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieHolder {

       return MovieHolder(MovieViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieHolder, position: Int) {

                      val movies=differ.currentList[position]
         Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ movies.poster_path}")
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