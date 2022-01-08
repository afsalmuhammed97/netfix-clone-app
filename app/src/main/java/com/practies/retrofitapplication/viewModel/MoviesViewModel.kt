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
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
//somfsfs
f s
@Inject
constructor(private val repository: MovieRepository):ViewModel() {
    private var upComingMovieList= listOf<Result>()
    private var latestMoveList= listOf<Result>()
    private var  nowPlayingMovieList= listOf<Result>()
    private var topRatedMoviesList= listOf<Result>()

    val upComing=MutableLiveData<Movie>()
    val  upComingResponse:MutableLiveData<Movie>
     get() = upComing

    val _response1= MutableLiveData <Movie>()     //< List<Movie>>()
    val responseMovie:LiveData<Movie>

        get() = _response1

    init {
        getAllMovies()
      //  getUpComingMovies()
//        getLatestMovies()
//        getTopRatedMovies()
//        getNowPlayingMovies()
    }

    private fun getAllMovies()= viewModelScope.launch {
        repository.getPopularMovies().let { response ->

            if (response.isSuccessful){
                _response1.postValue(response.body())
            }else{
                Log.d("Tag","getAllMoviesError :${response.code()}")
            }
        }
    }

    private fun getUpComingMovies()= viewModelScope.launch {
           val upComing=   repository.getUpComingMovies()

            if (upComing.isSuccessful){
                upComingMovieList=upComing.body()!!.results
            }else{
                Log.d("Tag","getUpComingMoviesError :${upComing.code()}")
            }
        }

    private fun getTopRatedMovies()= viewModelScope.launch {
        val movie =   repository.getTopRatedMovies()

        if (movie.isSuccessful){
           topRatedMoviesList=movie.body()!!.results
        }else{
            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
        }
    }

    private fun getNowPlayingMovies()= viewModelScope.launch {
        val movie =   repository.getNowPlayingMovies()

        if (movie.isSuccessful){
            nowPlayingMovieList=movie.body()!!.results
        }else{
            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
        }
    }

    private fun getLatestMovies()= viewModelScope.launch {
        val movie =   repository.getLatestMovies()

        if (movie.isSuccessful){
            latestMoveList=movie.body()!!.results
        }else{
            Log.d("Tag","getUpComingMoviesError :${movie.code()}")
        }
    }
    }




