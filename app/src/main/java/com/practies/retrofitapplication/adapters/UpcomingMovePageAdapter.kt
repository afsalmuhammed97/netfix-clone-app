package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.databinding.ComingSoonItemBinding
import com.practies.retrofitapplication.model.Movie

class UpcomingMovePageAdapter:PagingDataAdapter<Movie,UpcomingMovePageAdapter.MyHolder>(differCallback) {

       companion object{

           val differCallback=object :DiffUtil.ItemCallback<Movie>(){

               override fun areItemsTheSame(oldItem: Movie, newItem: Movie)=oldItem.id==newItem.id

               override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =  oldItem==newItem

           }
       }

    class MyHolder( val binding: ComingSoonItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

      val item=getItem(position)




          holder.binding.apply {
              if (item != null) {
                  movieName.text=item.title
                  discription.text=item.overview
                  releaseDateText.text=item.release_date
              }
          }


        Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${item?.poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            //.centerCrop()
            .centerInside()
            .into(holder.binding.moviePoster)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
       return  MyHolder(ComingSoonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


}