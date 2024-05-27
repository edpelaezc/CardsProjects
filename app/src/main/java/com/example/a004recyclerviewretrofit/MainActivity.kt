package com.example.a004recyclerviewretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a004recyclerviewretrofit.database.RealmSyncService
import com.example.a004recyclerviewretrofit.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var baseURL = "http://www.balam-knights.com"
    var apiKey = "81818BBF-C772-411D-9BFA-3CAFA12D6077"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CardService::class.java)
        val userId =  UserIdRequest("1")
        val call = service.getCards (userId)

        val realmSyncService = RealmSyncService()
        val cardsList = realmSyncService.getMovies()

        // show cards from db if it is not empty
        if (cardsList.isNotEmpty()) {
            var recyclerView = binding.moviesRecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            var adapter = CardsAdapter(cardsList.toList())
            recyclerView.adapter = adapter
        }

        // instead, call rest api and then save to db
        call.enqueue(object : retrofit2.Callback<List<CardResponse>> {
            override fun onResponse(call: retrofit2.Call<List<CardResponse>>, response: retrofit2.Response<List<CardResponse>>) {
                if (response.code() == 200) {
                    val cardsResponse = response.body()!!

                    cardsResponse.forEach { card ->
                        realmSyncService.doSync(card)
                    }

                    var recyclerView = binding.moviesRecyclerView
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    var adapter = CardsAdapter(cardsResponse)
                    recyclerView.adapter = adapter
                }
            }

            val rev = realmSyncService.getMovies()

            override fun onFailure(call: retrofit2.Call<List<CardResponse>>, t: Throwable) {
                var e = t.message
            }
        })

    }
}