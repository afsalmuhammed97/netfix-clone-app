package com.practies.retrofitapplication

import com.practies.retrofitapplication.model.Movie

//<T>
data class ApiResponse(
    val page: Int,
    val movie: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)

//data class MovieResult(
//    val adult: Boolean,
//    val backdrop_path: String,
//    val genre_ids: List<Int>,
//    val id: Int,
//    val original_language: String,
//    val original_title: String,
//    val overview: String,
//    val popularity: Double,
//    val poster_path: String,
//    val release_date: String,
//    val title: String,
//    val video: Boolean,
//    val vote_average: Double,
//    val vote_count: Int
//)