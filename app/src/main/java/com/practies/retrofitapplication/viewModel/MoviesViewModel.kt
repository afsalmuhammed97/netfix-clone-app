package com.practies.retrofitapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.practies.retrofitapplication.ApiResponse
import com.practies.retrofitapplication.model.Movie
import com.practies.retrofitapplication.paging.MoviePagingSource
import com.practies.retrofitapplication.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import retrofit2.Response
import javax.inject.Inject

@HiltViewModel


class MoviesViewModel @Inject constructor ( private val repository: MovieRepository):ViewModel() {
     val popularMoviesLiveData = MutableLiveData<Response<ApiResponse>>()
     val topRatedMovieLiveData = MutableLiveData<Response<ApiResponse>>()
     val upComingMovieLiveData = MutableLiveData<Response<ApiResponse>>()
     val nowPLayingMovieLiveData = MutableLiveData<Response<ApiResponse>>()

     // val trendingMovieLiveData=MutableLiveData<Response<ApiResponse>>()
     var funMovieList = listOf<Movie>()

     init {
         getPopularMovies()
         getUpComingMovies()
         getTopRatedMovies()
         getNowPlayingMovies()
         // getTrendigMovies()

     }


//    val upComingMovieData=Pager(PagingConfig(pageSize = 20)) {
//        Log.i("TEst","pagigng called")
//        MoviePagingSource(repository)
//
//    }.flow.cachedIn(viewModelScope)





    private fun getTopRatedMovies() {
            viewModelScope.launch {
                val response: Response<ApiResponse> = repository.getTopRatedMovies()
                    topRatedMovieLiveData.value = response
                Log.i("MoveiViewModel", "getTopRatedMovies called")
            }
        }


     private fun getUpComingMovies() {
         viewModelScope.launch {
             val response: Response<ApiResponse> = repository.getUpComingMovies(2)
             upComingMovieLiveData.value = response
             Log.i("MoveiViewModel", "getUpcomingMovies called")

         }
     }

     private fun getNowPlayingMovies() {
         viewModelScope.launch {
             val response: Response<ApiResponse> = repository.getNowPlayingMovies()
             nowPLayingMovieLiveData.value = response
             Log.i("MoveiViewModel", "getNowPlayingMovies called")

         }
     }

     private fun getPopularMovies() {
         viewModelScope.launch {
             val response: Response<ApiResponse> = repository.getPopularMovies()
             popularMoviesLiveData.value = response
             Log.i("MoveiViewModel", "getPopulerMovies called")


         }
     }

 }






