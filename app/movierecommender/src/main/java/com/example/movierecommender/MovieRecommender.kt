package com.example.movierecommender

import android.util.Log
import com.example.movierecommender.model.Movie
import com.example.movierecommender.model.SearchResponseMovies
import com.example.movierecommender.network.Api
import retrofit2.await

class MovieRecommender {

    companion object {

        suspend fun run(input: String): MutableList<Movie> {
            var moviesTemp: MutableList<Movie>
            val inputSplit = input.split(" ").toTypedArray()
            Log.v("split", inputSplit.size.toString())
            moviesTemp = buildMovieListFromInput(inputSplit)
            return moviesTemp

        }

        private suspend fun buildMovieListFromInput(inputSplit: Array<String>): MutableList<Movie> {
            val moviesListFromInput = mutableListOf<Movie>()
            for (input in inputSplit) {
                moviesListFromInput.add(getMovieFromSearch(input))
            }
            return moviesListFromInput
        }

        private suspend fun getMovieFromSearch(input: String): Movie {
            val responseMovies: SearchResponseMovies =
                Api.retrofitService.getMoviesSearch(input).await()
            Log.v("Response", responseMovies.results[0].original_title)
            return responseMovies.results[0]

        }
    }
    }

