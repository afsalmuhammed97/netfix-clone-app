package com.practies.retrofitapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import retrofit2.Response
import javax.inject.Inject

//@HiltViewModel

//somfsfs

 //@Inject  constructor(private val repository: MovieRepository):ViewModel()
class MoviesViewModel(private val repository: MovieRepository):ViewModel() {
     val popularMoviesLiveData = MutableLiveData<Response<Movie>>()
     val topRatedMovieLiveData = MutableLiveData<Response<Movie>>()
     val upComingMovieLiveData = MutableLiveData<Response<Movie>>()
     val nowPLayingMovieLiveData = MutableLiveData<Response<Movie>>()
     // val trendingMovieLiveData=MutableLiveData<Response<Movie>>()


     init {
         getPopularMovies()
         getUpComingMovies()
         getTopRatedMovies()
         getNowPlayingMovies()
         // getTrendigMovies()

     }

     fun getTopRatedMovies() {
         viewModelScope.launch {
             val response: Response<Movie> = repository.getTopRatedMovies()
             topRatedMovieLiveData.value = response
             Log.i("MoveiViewModel", "getTopRatedMovies called")
         }
     }

     fun getUpComingMovies() {
         viewModelScope.launch {
             val response: Response<Movie> = repository.getUpComingMovies()
             upComingMovieLiveData.value = response
             Log.i("MoveiViewModel", "getUpcomingMovies called")

         }
     }

     fun getNowPlayingMovies() {
         viewModelScope.launch {
             val response: Response<Movie> = repository.getNowPlayingMovies()
             nowPLayingMovieLiveData.value = response
             Log.i("MoveiViewModel", "getNowPlayingMovies called")

         }
     }

     fun getPopularMovies() {
         viewModelScope.launch {
             val response: Response<Movie> = repository.getPopularMovies()
             popularMoviesLiveData.value = response
             Log.i("MoveiViewModel", "getPopulerMovies called")

         }
     }


//     fun getTrendigMovies(){
//         viewModelScope.launch {
//             val response: Response<Movie> = repository.getLatestMovies()
//             trendingMovieLiveData.value = response
//             Log.i("MoveiViewModel","getTrendingMovies called")
//
//         }


//    fun popularMovies(){
//        viewModelScope.launch {
//            val respose: Response<Movie> = repository.getPopular()
//            popularmoviesLiveData.value = respose
//        }
//    }

     private fun getAllMovies() = viewModelScope.launch {
       val response=  repository.getPopularMovies().let { response ->

             if (response.isSuccessful) {
             popularMoviesLiveData.value=response                     //.postValue(response.body())
             } else {
                 Log.d("Tag", "getAllMoviesError :${response.code()}")
             }
         }
     }
 }
//    private fun getUpComingMovies()= viewModelScope.launch {
//           val upComing=   repository.getUpComingMovies()
//
//            if (upComing.isSuccessful){
//                upComingMovieList=upComing.body()!!.results
//            }else{
//                Log.d("Tag","getUpComingMoviesError :${upComing.code()}")
//            }
//        }
//
//    private fun getTopRatedMovies()= viewModelScope.launch {
//        val movie =   repository.getTopRatedMovies()
//
//        if (movie.isSuccessful){
//           topRatedMoviesList=movie.body()!!.results
//        }else{
//            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
//        }
//    }
//
//    private fun getNowPlayingMovies()= viewModelScope.launch {
//        val movie =   repository.getNowPlayingMovies()
//
//        if (movie.isSuccessful){
//            nowPlayingMovieList=movie.body()!!.results
//        }else{
//            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
//        }
//    }
//
//    private fun getLatestMovies()= viewModelScope.launch {
//        val movie =   repository.getLatestMovies()
//
//        if (movie.isSuccessful){
//            latestMoveList=movie.body()!!.results
//        }else{
//            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
//        }
//    }





