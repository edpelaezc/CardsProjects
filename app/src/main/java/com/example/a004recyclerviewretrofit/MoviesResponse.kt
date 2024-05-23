package com.example.a004recyclerviewretrofit

import com.google.gson.annotations.SerializedName

class MoviesResponse (
    val page: Long,
    val results: List<Result>,

    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long
)

class Result (
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIDS: List<Long>,
    val id: Long,
    @SerializedName("original_language")
    val originalLanguage: OriginalLanguage,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long
)

enum class OriginalLanguage(val value: String) {
    En("en"),
    Fr("fr"),
    Ko("ko");

    companion object {
        public fun fromValue(value: String): OriginalLanguage = when (value) {
            "en" -> En
            "fr" -> Fr
            "ko" -> Ko
            else -> throw IllegalArgumentException()
        }
    }
}