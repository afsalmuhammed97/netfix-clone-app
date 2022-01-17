package com.practies.retrofitapplication.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.api.ApiService

class MoviePagingSource (val api:ApiService):PagingSource<Int,Movie>(){
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
               val page=params.key?:1     // DEFAULT_PAGE_INDEX

             return    try {
                     val response = api.getUpComingMovies(page)


                 }

    }


}