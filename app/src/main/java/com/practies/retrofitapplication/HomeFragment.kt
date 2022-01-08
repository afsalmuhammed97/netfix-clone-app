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
    lateinit var allMovie: List<com.practies.retrofitapplication.Movie>
    var upComing = listOf<Result>()
    var popular = listOf<Result>()
    var toprated = listOf<Result>()
    var nowPlaying = listOf<Result>()
    // var moviList= listOf<Result>()


    var list = arrayListOf<String>()
    val movieData = listOf<Result>()
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

       viewModel.responseMovie.observe(requireActivity()       ,{listMovies ->
           movieAdapter!!.movies=listMovies.results


       })

    }


}
//    @SuppressLint("NotifyDataSetChanged")
//    private fun makeApiRequestAndShowResult(){
//
//
//
//            val api =Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ApiService ::class.java)
//
//            GlobalScope.launch(Dispatchers.IO) {
//
//                try {
//                   val response = api.getUpComingMovies(APIKEY)
//                    val popularMovies=api.getPopularMovies(APIKEY)
//                  val topRatedMovies=api.getTopRatedMovies(APIKEY)
//                   val trendingMovies=api.getNowPlaying(APIKEY)
//
//                    Log.i("Main","result ${response.body().toString()}")
//
//
//                    withContext(Dispatchers.Main) {
//
//                       val temTopRated=topRatedMovies.body()!!.results
//                        toprated=temTopRated
//                        val tempPopular=popularMovies.body()!!.results
//                          popular=tempPopular
//                        val tempTrending=trendingMovies.body()!!.results
//                        nowPlaying=tempTrending
//                        val tempdata =response.body()!!.results
//                        upComing = tempdata
//
//
//                        if (response.isSuccessful)
//                            successRequest=true
//                            movieAdapter?.notifyDataSetChanged()
//                            //  =popularMovies.body()!!.results
//
//                        //for testing purpus only
//
//                          testList=nowPlaying
//                        //////////////////////
//                        val img =upComing[0]
//
//                        // binding.mainImg.setImageResource(img.poster_path)backdrop_path
//                        Glide.with(requireContext())
//                            .load("http://image.tmdb.org/t/p/w500${img.poster_path}")
//                            .centerCrop()
//                            .into(binding.mainImg)
//                      //  movieAdapter = MovieAdapter(popular)
//
//                        binding.firstRv.hasFixedSize()
//                        binding.firstRv.layoutManager =
//                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                        binding.firstRv.setItemViewCacheSize(12)
//                        binding.firstRv.adapter = movieAdapter
//
//
////                        movieAdapter = MovieAdapter(toprated)
////                        binding.secondRv.hasFixedSize()
////                        binding.secondRv.layoutManager =
////                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
////                        binding.secondRv.setItemViewCacheSize(12)
////                        binding.secondRv.adapter = movieAdapter
//
//
//                     //   movieAdapter = MovieAdapter(nowPlaying)
//                        binding.thirdRv.hasFixedSize()
//                        binding.thirdRv.layoutManager =
//                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                        binding.thirdRv.setItemViewCacheSize(12)
//                        binding.thirdRv.adapter = movieAdapter
//
//
//
//
//
//                       // Log.i("Main", "final list${moviList}")
//
//
//
//                        if (successRequest){
//                            //   binding.progressBar1.visibility=view.INVISIBLE
//                            binding.progressBar0.setVisibility(View.GONE)
//                            binding.progressBar1.setVisibility(View.GONE)
//                            binding.progressBar2.setVisibility(View.GONE)
//                            binding.progressBar3.setVisibility(View.GONE)
//                          //  makeApiRequestAndShowResult()
//                        }
//
//
//                    }
//                }catch (e:Exception){
//                    Log.e("Main","Error${e.message}")
//                }
//
//
//            }
//                if(! successRequest){
//                    binding.progressBar0.visibility = View.VISIBLE;
//                    binding.progressBar1.visibility = View.VISIBLE;
//                                binding.progressBar2.visibility = View.VISIBLE
//                                binding.progressBar3.visibility = View.VISIBLE
//
//                }
//
//        }
//    }

 //e4bbe4d35eb4b28c8b0083304f7b662f

///  https://api.themoviedb.org/3/movie/upcoming?api_key=e4bbe4d35eb4b28c8b0083304f7b662f&language=en-US&page=1