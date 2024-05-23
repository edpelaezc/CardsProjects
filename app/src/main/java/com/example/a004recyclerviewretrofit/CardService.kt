package com.example.a004recyclerviewretrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface CardService {
    @Headers("x-api-key: 81818BBF-C772-411D-9BFA-3CAFA12D6077")
    @POST("/accesos_dev/api/cards/")
    fun getCards(@Body body: UserIdRequest) : Call<List<CardResponse>>
}