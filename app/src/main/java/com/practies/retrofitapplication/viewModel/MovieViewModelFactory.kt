package com.practies.retrofitapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practies.retrofitapplication.repository.MovieRepository

class MovieViewModelFactory (private val repository: MovieRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MoviesViewModel(repository)   as T
    }
}