package com.example.movierecommender.model

data class SearchResponseMovies(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
