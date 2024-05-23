package com.example.a004recyclerviewretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MoviesService {
    @GET("3/movie/popular")
    fun getMovies(@Header("Authorization") authHeader: String,
                  @Query("api_key") apiKey: String): Call<MoviesResponse>
}