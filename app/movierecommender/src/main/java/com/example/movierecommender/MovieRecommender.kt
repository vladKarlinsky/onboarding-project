package com.example.movierecommender

import androidx.annotation.VisibleForTesting
import com.example.movierecommender.model.Movie
import com.example.movierecommender.model.SearchResponseMovies
import com.example.movierecommender.network.Api
import retrofit2.await

class MovieRecommender {

    companion object Recommender {

        suspend fun run(input: String): MutableList<Movie> {
            var moviesTemp: MutableList<Movie>
            val readyInput = preProcessInput(input)
            val inputSplit = readyInput.split(" ").toTypedArray()
            moviesTemp = buildMovieListFromInput(inputSplit)
            return moviesTemp

        }

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        internal fun preProcessInput(input: String): String {
            var readyInput = input
            if (input.endsWith(" "))
                readyInput = readyInput.subSequence(0,readyInput.length-1) as String
            if (input.startsWith(" "))
                readyInput = readyInput.subSequence(1,readyInput.length) as String
            return readyInput
        }

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        internal suspend fun buildMovieListFromInput(inputSplit: Array<String>): MutableList<Movie> {
            val moviesListFromInput = mutableListOf<Movie>()
            for (input in inputSplit) {
                moviesListFromInput.add(getMovieFromSearch(input))
            }
            return moviesListFromInput
        }

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        internal suspend fun getMovieFromSearch(input: String): Movie {
            val responseMovies: SearchResponseMovies =
                Api.retrofitService.getMoviesSearch(input).await()
            return responseMovies.results[0]

        }
    }
}

