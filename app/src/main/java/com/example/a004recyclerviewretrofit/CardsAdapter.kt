package com.example.a004recyclerviewretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a004recyclerviewretrofit.databinding.MovieItemBinding

class CardsAdapter (private val cards: List<CardResponse>) : RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        // Inflate the layout using View Binding
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val movie = cards[position]
        holder.bind(movie)
    }
    override fun getItemCount() = cards.size
}