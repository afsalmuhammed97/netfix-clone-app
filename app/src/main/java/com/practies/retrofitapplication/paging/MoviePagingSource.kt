package com.practies.retrofitapplication.paging


import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.model.Movie
import com.practies.retrofitapplication.repository.MovieRepository

class MoviePagingSource(private val repository: MovieRepository): PagingSource<Int,Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
       return  try {
           val currentPage=params.key?:1
           val response=repository.getUpComingMovies(currentPage)

                    Log.i("BBB",response.message())
           response.body()?.movie?.get(0)?.let { Log.i("CCC", it.title) }

            Log.i("RESPONSE",response.message())

          val data= response.body()?.movie

           val responseData= mutableListOf<Movie>()
           if (data != null) {
               responseData.addAll(data)
           }

           LoadResult.Page(
               data=responseData,
               prevKey = if (currentPage==1) null else -1,
               nextKey = currentPage.plus(1)
           )

       }catch (e:Exception){
           LoadResult.Error(e)
       }
    }
}