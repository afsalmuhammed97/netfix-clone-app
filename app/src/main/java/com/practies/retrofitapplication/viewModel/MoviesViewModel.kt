package com.practies.retrofitapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.repository.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

//@HiltViewModel

//somfsfs

 //@Inject  constructor(private val repository: MovieRepository):ViewModel()
class MoviesViewModel(private val repository: MovieRepository):ViewModel() {
     val popularMoviesLiveData = MutableLiveData<Response<Movie>>()
     val topRatedMovieLiveData = MutableLiveData<Response<Movie>>()
     val upComingMovieLiveData = MutableLiveData<Response<Movie>>()
     val nowPLayingMovieLiveData = MutableLiveData<Response<Movie>>()

     // val trendingMovieLiveData=MutableLiveData<Response<Movie>>()
     var funMovieList = listOf<Result>()

     init {
         getPopularMovies()
         getUpComingMovies()
         getTopRatedMovies()
         getNowPlayingMovies()
         // getTrendigMovies()

     }

     fun getTopRatedMovies() {


         try {

             viewModelScope.launch {
                 val response: Response<Movie> = repository.getTopRatedMovies()


                 topRatedMovieLiveData.value = response
             }
         }catch (e:Exception){
             Log.i("Exception","Request failed")
         }






     }

     fun getUpComingMovies() {
         try {
             viewModelScope.launch {
                 val response: Response<Movie> = repository.getUpComingMovies()
                 upComingMovieLiveData.value = response
                 Log.i("MoveiViewModel", "getUpcomingMovies called")

             }
         }catch (e:Exception){
             Log.i("Exception","Request failed")
         }

     }

     fun getNowPlayingMovies() {
         try {
             viewModelScope.launch {
                 val response: Response<Movie> = repository.getNowPlayingMovies()
                 nowPLayingMovieLiveData.value = response
                 Log.i("MoveiViewModel", "getNowPlayingMovies called")

             }

         }catch (e:Exception){
             Log.i("Exception","Request failed")
         }
     }

     fun getPopularMovies() {

         try {
             viewModelScope.launch {
                 val response: Response<Movie> = repository.getPopularMovies()
                 popularMoviesLiveData.value = response

                 funMovieList=response.body()!!.results

             }

         }catch (e:Exception){
             Log.i("Exception","Request failed")
         }

     }

 }






