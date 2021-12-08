package com.example.movielistgenerator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistgenerator.databinding.MovieRecommendationItemBinding
import com.example.movierecommender.model.Movie

class MovieListAdapter:
    ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(DiffCallback) {

    class MovieViewHolder (
        private var binding: MovieRecommendationItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
            fun bind(movie: Movie){
                binding.movieData = movie
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.backdrop_path == newItem.backdrop_path
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        return MovieViewHolder(
            MovieRecommendationItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.bind(movieItem)
    }
}