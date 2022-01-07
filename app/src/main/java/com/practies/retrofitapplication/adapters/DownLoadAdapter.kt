package com.practies.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.databinding.DownLoadsItemBinding
import javax.xml.transform.Result

class DownLoadAdapter (val downLoadList:List<com.practies.retrofitapplication.Result> ):RecyclerView.Adapter<DownLoadAdapter.MyHolder>() {
    class MyHolder(val binding: DownLoadsItemBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownLoadAdapter.MyHolder {
       return MyHolder(DownLoadsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DownLoadAdapter.MyHolder, position: Int) {
      val movie=downLoadList[position]

        Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${ downLoadList[position].poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            .centerCrop()
            .into(holder.binding.moviePoster)

        holder.binding.moveName.text=movie.title




    }

    override fun getItemCount()= downLoadList.size
}