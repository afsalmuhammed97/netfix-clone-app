package com.practies.retrofitapplication.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.Ui.base.BaseFragment
import com.practies.retrofitapplication.Utill.handleApiError
import com.practies.retrofitapplication.Utill.loadImage
import com.practies.retrofitapplication.adapters.MovieAdapter
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.api.Resource
import com.practies.retrofitapplication.databinding.FragmentHomeBinding
import com.practies.retrofitapplication.repository.MainRepository
import com.practies.retrofitapplication.viewModel.MainViewModel


class HomeFragment : BaseFragment<MainViewModel,FragmentHomeBinding,MainRepository>(){
        lateinit var popularMovieAdapter:MovieAdapter
        lateinit var topRatedMovieAdapter:MovieAdapter
        lateinit var trendingMovieAdapter: MovieAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularMovieAdapter= MovieAdapter()
        topRatedMovieAdapter= MovieAdapter()
        trendingMovieAdapter= MovieAdapter()
          viewModel.apply {
              getPopularMovies()
              getTopRatedMovies()
              getTrendingMovies()
          }

        viewModel.popularMovieResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                   is Resource.Success->{
                       val data=it.value.body()!!.results
                       popularMovieAdapter.differ.submitList(data)
                       popularMovieAdapter.notifyDataSetChanged()
                        setFirstRv()
                   }
                is Resource.Failure->{
                    handleApiError(it)
                    binding.progressBar1.visibility=View.VISIBLE

                }
            }
        })

        viewModel.topRatedMovieResponse.observe(viewLifecycleOwner, Observer {

            when(it){
                is Resource.Success->{
                    val data=it.value.body()!!.results
                    topRatedMovieAdapter.differ.submitList(data)
                    topRatedMovieAdapter.notifyDataSetChanged()
                    setSecondRv()
                }
                is Resource.Failure->{
                    handleApiError(it,)
                    binding.progressBar2.visibility=View.VISIBLE

                }
            }
        })
        viewModel.trendingMovieResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success->{
                    val data=it.value.body()!!.results
                    trendingMovieAdapter.differ.submitList(data)
                    trendingMovieAdapter.notifyDataSetChanged()
                    setThirdRv()
                    loadImage(data[0],binding.mainImg)
                }
                is Resource.Failure->{
                    handleApiError(it)
                    binding.progressBar3.visibility=View.VISIBLE

                }
            }

        })





    }



    override fun getViewModel()=MainViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?
    )= FragmentHomeBinding.inflate(inflater,container,false)

    override fun getFragmentRepository()=MainRepository(retrofitInstance.buildApi(ApiService::class.java))



    fun setFirstRv(){
        binding.firstRv.apply {

            adapter= popularMovieAdapter
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)


        }}
        fun setSecondRv(){
            binding.secondRv.apply {


            adapter=topRatedMovieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            }
        }

        fun setThirdRv(){

            binding.thirdRv.apply {

            adapter=trendingMovieAdapter
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)


        }

        }

    }





//        upCominingMovieAdapter=MovieAdapter()
//        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner,{Response->
//
//            if (Response.isSuccessful && Response.code()==200){
//                Response.body().let { popularMovie->
//                    if (popularMovie != null) {
//                        popularMovieAdapter.differ.submitList(popularMovie.results)
//                        popularMovieAdapter.notifyDataSetChanged()         // movies=popularMovie.results
//                        //  popularMovieAdapter.notifyDataSetChanged()
//                        val img =popularMovie.results[0]
//            Glide.with(requireContext())
//                .load("http://image.tmdb.org/t/p/w500${img.backdrop_path}")    //poster_path
//                //.centerCrop()
//                .fitCenter()
//               .into(binding.mainImg)
//
//                    }else{
//                        Toast.makeText(context,"data null",Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            }else{
//                binding.progressBar1.visibility = View.VISIBLE
//                binding.progressBar0.visibility = View.VISIBLE
//            }
//
//        })
//        binding.firstRv.apply {
//
//            adapter= popularMovieAdapter
//            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            setHasFixedSize(true)
//            setItemViewCacheSize(20)
//
//
//        }
//
//
//
//        viewModel.topRatedMovieLiveData.observe(viewLifecycleOwner,{Response->
//            if (Response.isSuccessful && Response.code()==200){
//                Response.body().let { topRatedMovie->
//                    if (topRatedMovie != null) {
//                       topRatedMovieAdapter.differ.submitList(topRatedMovie.results)
//                        topRatedMovieAdapter.notifyDataSetChanged()
//                        //trendingMovieAdapter.movies=topRatedMovie.results
//                    }
//                }
//            }else{
//                binding.progressBar2.visibility = View.VISIBLE
//            }
//        })
//        binding.secondRv.apply {
//
//
//            adapter=topRatedMovieAdapter
//            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            setHasFixedSize(true)
//            setItemViewCacheSize(20)
//
//
//        }
//
//
//
//
//        viewModel.upComingMovieLiveData.observe(viewLifecycleOwner,{Response->
//
//            if (Response.isSuccessful && Response.code()==200){
//                Response.body().let { upComingMovie->
//                    if (upComingMovie != null) {
//                    upCominingMovieAdapter.differ.submitList(upComingMovie.results)
//                        upCominingMovieAdapter.notifyDataSetChanged()
//                    }
//                }
//
//            }else{
//                binding.progressBar3.visibility = View.VISIBLE
//            }
//
//
//        })
//
//
//        binding.thirdRv.apply {
//
//            adapter=upCominingMovieAdapter
//            layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            setHasFixedSize(true)
//            setItemViewCacheSize(20)
//
//
//        }
//
//
//
//
//    }
//
//
//}
//
//

 //e4bbe4d35eb4b28c8b0083304f7b662f

///  https://api.themoviedb.org/3/movie/upcoming?api_key=e4bbe4d35eb4b28c8b0083304f7b662f&language=en-US&page=1