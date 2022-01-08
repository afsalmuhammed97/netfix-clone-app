package com.practies.retrofitapplication

import java.io.Serializable

data class Result(
    val adult: Boolean,
    var backdrop_path: String,
    var id: Int,
    var original_language: String,
    var overview: String,
    var poster_path: String,
    var release_date: String,
    var title: String,

    ):Serializable

// val genre_ids: List<Int>,
// val original_title: String,
// val popularity: Double,
//   val video: Boolean,
//  val vote_average: Double,
//   val vote_count: Int