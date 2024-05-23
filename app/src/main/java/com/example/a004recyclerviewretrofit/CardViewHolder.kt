package com.example.a004recyclerviewretrofit

import androidx.recyclerview.widget.RecyclerView
import com.example.a004recyclerviewretrofit.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class CardViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(card: CardResponse) {
        binding.movieTitle.text = card.cardName
        Picasso.get().load(card.cardImageURL).into(binding.movieImage)
    }
}