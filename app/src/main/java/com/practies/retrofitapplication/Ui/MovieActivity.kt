package com.practies.retrofitapplication.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practies.retrofitapplication.R
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMovieBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val movieData=  intent.getSerializableExtra("movie") as Result



        binding.movieName.text=movieData.title
        binding.discription.text=movieData.overview
        binding.releaseDateText.text=movieData.release_date

        Glide.with(this).load("http://image.tmdb.org/t/p/w500${movieData.poster_path}")
            .apply(RequestOptions.placeholderOf(R.drawable.music1))
            .centerCrop()
            .into(binding.moviePoster)
    }
}