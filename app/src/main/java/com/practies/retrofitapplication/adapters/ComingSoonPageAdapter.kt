package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.databinding.ComingSoonItemBinding
//val upComingMovies: List<Result>
class ComingSoonPageAdapter():RecyclerView.Adapter<ComingSoonPageAdapter.MyHolder>() {
    class MyHolder (val binding: ComingSoonItemBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallback=object :DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
          return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
          return  newItem ==oldItem
        }

    }
     val differ=AsyncListDiffer(this,diffCallback)

  //  var upComingMovies:List<Result>
//    get() = differ.currentList
//    set(value) {
//        differ.submitList(value)
//    }



    override fun getItemCount()= differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        return MyHolder(ComingSoonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val movie=  differ.currentList[position]


       Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ movie.poster_path}")
           .apply(RequestOptions.placeholderOf(R.drawable.music1))
           //.centerCrop()
          .centerInside()
           .into(holder.binding.moviePoster)


        holder.binding.apply {
            movieName.text=movie.title
            discription.text=movie.overview
            releaseDateText.text=movie.release_date
        }
    }




}