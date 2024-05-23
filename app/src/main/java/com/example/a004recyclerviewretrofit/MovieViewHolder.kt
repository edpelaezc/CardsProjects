package com.example.a004recyclerviewretrofit


import androidx.recyclerview.widget.RecyclerView
import com.example.a004recyclerviewretrofit.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

var baseImageURL: String = "https://image.tmdb.org/t/p/w220_and_h330_face"

class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Result) {
        binding.movieTitle.text = movie.title
        Picasso.get().load(baseImageURL + movie.posterPath).into(binding.movieImage)
    }
}