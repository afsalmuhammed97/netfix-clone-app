package com.practies.retrofitapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practies.retrofitapplication.repository.BaseRepository
import com.practies.retrofitapplication.repository.MainRepository
import com.practies.retrofitapplication.repository.MovieRepository
import java.lang.IllegalArgumentException

class MovieViewModelFactory (private val repository:BaseRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

     return   when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository as MainRepository)

            else -> throw  IllegalArgumentException("View model class not found")

        }    as T




    }
}