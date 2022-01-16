package com.practies.retrofitapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.api.Resource
import com.practies.retrofitapplication.repository.BaseRepository
import com.practies.retrofitapplication.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: MainRepository):ViewModel() {

    private val _topRatedResponse:MutableLiveData<Resource<Response<Movie>>> =MutableLiveData()
    val topRatedMovieResponse:LiveData<Resource<Response<Movie>>>
    get() = _topRatedResponse

    private val _popularResponse:MutableLiveData<Resource<Response<Movie>>> =MutableLiveData()
    val popularMovieResponse:LiveData<Resource<Response<Movie>>>
        get() = _popularResponse



    private val _UpComingResponse:MutableLiveData<Resource<Response<Movie>>> =MutableLiveData()
    val upComingMovieResponse:LiveData<Resource<Response<Movie>>>
        get() = _UpComingResponse

    private val _trendingResponse:MutableLiveData<Resource<Response<Movie>>> =MutableLiveData()
    val trendingMovieResponse:LiveData<Resource<Response<Movie>>>
        get() = _trendingResponse





    fun getPopularMovies()=viewModelScope.launch {
                _popularResponse.value=  repository.getPopularMovies()

    }

    fun getTopRatedMovies()=viewModelScope.launch {
        _topRatedResponse.value=repository.getTopRatedMovies()
    }

    fun getUpComingMovies()=viewModelScope.launch {

               _UpComingResponse.value=repository.getUpcomingMovies()

    }

    fun getTrendingMovies()=viewModelScope.launch {

        _trendingResponse.value=repository.getTrendingMovies()

    }


}