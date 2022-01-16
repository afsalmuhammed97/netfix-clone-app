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
class MoviesViewModel(private val repository: MovieRepository):ViewModel() {}
     val popularMoviesLiveData = MutableLiveData<Response<Movie>>()
     val topRatedMovieLiveData = MutableLiveData<Response<Movie>>()
     val upComingMovieLiveData = MutableLiveData<Response<Movie>>()
     val nowPLayingMovieLiveData = MutableLiveData<Response<Movie>>()

//     // val trendingMovieLiveData=MutableLiveData<Response<Movie>>()
//     var funMovieList = listOf<Result>()
//
//     init {
//         getPopularMovies()
//         getUpComingMovies()
//         getTopRatedMovies()
//         getNowPlayingMovies()
//         // getTrendigMovies()
//
//     }
//
//     fun getTopRatedMovies() {
//
//
//         try {
//
//             viewModelScope.launch {
//                 val response: Response<Movie> = repository.getTopRatedMovies()
//
//
//                 topRatedMovieLiveData.value = response
//             }
//         }catch (e:Exception){
//             Log.i("Exception","Request failed")
//         }
//
//
//
//
//
//
//     }
//
//     fun getUpComingMovies() {
//         try {
//             viewModelScope.launch {
//                 val response: Response<Movie> = repository.getUpComingMovies()
//                 upComingMovieLiveData.value = response
//                 Log.i("MoveiViewModel", "getUpcomingMovies called")
//
//             }
//         }catch (e:Exception){
//             Log.i("Exception","Request failed")
//         }
//
//     }
//
//     fun getNowPlayingMovies() {
//         try {
//             viewModelScope.launch {
//                 val response: Response<Movie> = repository.getNowPlayingMovies()
//                 nowPLayingMovieLiveData.value = response
//                 Log.i("MoveiViewModel", "getNowPlayingMovies called")
//
//             }
//
//         }catch (e:Exception){
//             Log.i("Exception","Request failed")
//         }
//     }
//
//     fun getPopularMovies() {
//
//         try {
//             viewModelScope.launch {
//                 val response: Response<Movie> = repository.getPopularMovies()
//                 popularMoviesLiveData.value = response
//
//                 funMovieList=response.body()!!.results
//
//             }
//
//         }catch (e:Exception){
//             Log.i("Exception","Request failed")
//         }
//
//     }
//
// }

//
//constructor(private val repository: MovieRepository):ViewModel() {
//    private var upComingMovieList= listOf<Result>()
//    private var latestMoveList= listOf<Result>()
//    private var  nowPlayingMovieList= listOf<Result>()
//    private var topRatedMoviesList= listOf<Result>()
//
//    val upComing=MutableLiveData<Movie>()
//    val  upComingResponse:MutableLiveData<Movie>
//     get() = upComing
//
//    val _response1= MutableLiveData <Movie>()     //< List<Movie>>()
//    val responseMovie:LiveData<Movie>
//
//        get() = _response1
//
//    init {
//        getAllMovies()
//      //  getUpComingMovies()
////        getLatestMovies()
////        getTopRatedMovies()
////        getNowPlayingMovies()
//    }
//
//    private fun getAllMovies()= viewModelScope.launch {
//        repository.getPopularMovies().let { response ->
//
//            if (response.isSuccessful){
//                _response1.postValue(response.body())
//            }else{
//                Log.d("Tag","getAllMoviesError :${response.code()}")
//            }
//        }
//    }
//
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
//    }
//>>>>>>> Stashed changes
//
//
//
//
