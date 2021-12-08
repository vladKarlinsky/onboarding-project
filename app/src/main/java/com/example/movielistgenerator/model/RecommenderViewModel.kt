package com.example.movielistgenerator.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movierecommender.MovieRecommender
import com.example.movierecommender.model.Movie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }

class RecommenderViewModel : ViewModel() {

    private val _userInput = MutableLiveData<String>()
    private val userInput : LiveData<String> = _userInput

    private val _status = MutableLiveData<MovieApiStatus>()
    val status : LiveData<MovieApiStatus> = _status

    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies : LiveData<MutableList<Movie>> = _movies

    fun setUserInput(input : String){
        _userInput.value = input
    }

    fun getMoviesList() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                val moviesFromRecommender = MovieRecommender.Recommender.run(userInput.value.toString())
                _movies.value = moviesFromRecommender
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                Log.v("ERR", e.toString())
                _status.value = MovieApiStatus.ERROR
                _movies.value = mutableListOf()
            }
        }
    }
}