package com.practies.retrofitapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.practies.retrofitapplication.adapters.MovieAdapter
import com.practies.retrofitapplication.databinding.FragmentHomeBinding
import com.practies.retrofitapplication.model.Movie
import com.practies.retrofitapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

/// commit a067f2b4aa78811d4b6aa2e8357df92b3522afd4  on git

@AndroidEntryPoint
class HomeFragment : Fragment() {
    companion object {
        var testList = listOf<Movie>()
    }



    private val viewModel by activityViewModels<MoviesViewModel>()

    lateinit var binding: FragmentHomeBinding
   lateinit var popularMovieAdapter: MovieAdapter
   lateinit var topRatedMovieAdapter: MovieAdapter
   lateinit var upCominingMovieAdapter: MovieAdapter

    var successRequest: Boolean = false








    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)



//        if (!successRequest){  binding.progressBar1.visibility = View.VISIBLE
//                                binding.progressBar2.visibility = View.VISIBLE
//                                binding.progressBar3.visibility = View.VISIBLE }
//




        setMovieView()





        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setMovieView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setMovieView() {
        topRatedMovieAdapter= MovieAdapter()
        popularMovieAdapter = MovieAdapter()
        upCominingMovieAdapter=MovieAdapter()
        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner) { Response ->

            if (Response.isSuccessful && Response.code() == 200) {
                Response.body().let { popularMovie ->
                    if (popularMovie != null) {
                        popularMovieAdapter.differ.submitList(popularMovie.movie)
                        popularMovieAdapter.notifyDataSetChanged()

//                        val img = popularMovie.movies[0]
//                        Glide.with(requireContext())
//                            .load("http://image.tmdb.org/t/p/w500${img.backdrop_path}")    //poster_path
//                            //.centerCrop()
//                            .fitCenter()
//                            .into(binding.mainImg)

                    } else {
                        Toast.makeText(context, "data null", Toast.LENGTH_SHORT).show()
                    }

                }
            } else {
                binding.progressBar1.visibility = View.VISIBLE
                binding.progressBar0.visibility = View.VISIBLE
            }

        }
        binding.firstRv.apply {

            adapter= popularMovieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)


        }



        viewModel.topRatedMovieLiveData.observe(viewLifecycleOwner) { Response ->
            if (Response.isSuccessful && Response.code() == 200) {
                Response.body().let { topRatedMovie ->
                    if (topRatedMovie != null) {
                        topRatedMovieAdapter.differ.submitList(topRatedMovie.movie)
                        topRatedMovieAdapter.notifyDataSetChanged()
                        //trendingMovieAdapter.movies=topRatedMovie.movies
                    }
                }
            } else {
                binding.progressBar2.visibility = View.VISIBLE
            }
        }
        binding.secondRv.apply {


            adapter=topRatedMovieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)


        }




        viewModel.upComingMovieLiveData.observe(viewLifecycleOwner) { Response ->

            if (Response.isSuccessful && Response.code() == 200) {
                Response.body().let { upComingMovie ->
                    if (upComingMovie != null) {
                        upCominingMovieAdapter.differ.submitList(upComingMovie.movie)
                        upCominingMovieAdapter.notifyDataSetChanged()
                    }
                }

            } else {
                binding.progressBar3.visibility = View.VISIBLE
            }


        }


        binding.thirdRv.apply {

            adapter=upCominingMovieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)


        }




    }


}



 //e4bbe4d35eb4b28c8b0083304f7b662f

///  https://api.themoviedb.org/3/movie/upcoming?api_key=e4bbe4d35eb4b28c8b0083304f7b662f&language=en-US&page=1