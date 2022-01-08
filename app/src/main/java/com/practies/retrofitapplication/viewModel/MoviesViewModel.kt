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

@Inject
constructor(private val repository: MovieRepository):ViewModel() {

    val _response= MutableLiveData <Movie>()     //< List<Movie>>()
    val responseMovie:LiveData<Movie>
         get() = _response
    init {
        getAllMovies()

    }

    private fun getAllMovies()= viewModelScope.launch {
        repository.getPopularMovies().let { response ->

            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("Tag","getAllMoviesError :${response.code()}")
            }
        }
    }
}

//private fun <T> MutableLiveData<T>.postValue(body: Movie?) {
//
//}
