package com.practies.retrofitapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.practies.retrofitapplication.helper.Constants.APIKEY
import com.practies.retrofitapplication.helper.Constants.BASE_URL
import com.practies.retrofitapplication.adapters.MovieAdapter
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.databinding.FragmentHomeBinding
import com.practies.retrofitapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.notifyAll
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/// commit a067f2b4aa78811d4b6aa2e8357df92b3522afd4  on git

@AndroidEntryPoint
class HomeFragment : Fragment() {
    companion object {
        var testList = listOf<Result>()
    }

    private val viewModel: MoviesViewModel by viewModels()


    lateinit var binding: FragmentHomeBinding
    var movieAdapter: MovieAdapter? = null
    var successRequest: Boolean = false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // makeApiRequest()


    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


//        if (!successRequest){  binding.progressBar1.visibility = View.VISIBLE
//                                binding.progressBar2.visibility = View.VISIBLE
//                                binding.progressBar3.visibility = View.VISIBLE }


        //  makeApiRequestAndShowResult()


        setMovieView()





        return binding.root
    }

    private fun setMovieView() {
        movieAdapter = MovieAdapter()


           binding.firstRv.apply {
                      adapter=movieAdapter
               layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
               setHasFixedSize(true)
               setItemViewCacheSize(12)


           }
        binding.secondRv.apply {
            adapter=movieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(12)


        }

        binding.thirdRv.apply {
            adapter=movieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(12)


        }


        viewModel.responseMovie.observe(requireActivity()       ,{listMovies ->
           movieAdapter!!.movies=listMovies.results


            val img =listMovies.results[0]
            Glide.with(requireContext())
                .load("http://image.tmdb.org/t/p/w500${img.poster_path}")
                .centerCrop()
                .into(binding.mainImg)


        })


    }


}



 //e4bbe4d35eb4b28c8b0083304f7b662f

///  https://api.themoviedb.org/3/movie/upcoming?api_key=e4bbe4d35eb4b28c8b0083304f7b662f&language=en-US&page=1