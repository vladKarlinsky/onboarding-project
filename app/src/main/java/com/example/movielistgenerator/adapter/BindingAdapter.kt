package com.example.movielistgenerator

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movielistgenerator.adapter.MovieListAdapter
import com.example.movielistgenerator.model.MovieApiStatus
import com.example.movierecommender.model.Movie

private const val IMAGE_BASE_URL =
    "https://image.tmdb.org/t/p/original"

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MovieListAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgView.load(IMAGE_BASE_URL + imgUrl) {
            Log.v("IMG",IMAGE_BASE_URL + imgUrl)
            placeholder(R.drawable.loading_anim)
            error(R.drawable.ic_broken_image)

    }
}


@BindingAdapter("movieApiStatus")
fun bindStatus(Image: ImageView, status: MovieApiStatus?) {
    when (status) {
        MovieApiStatus.LOADING -> {
            Image.visibility = View.VISIBLE
            Image.setImageResource(R.drawable.loading_anim)
        }
        MovieApiStatus.ERROR -> {
            Image.visibility = View.VISIBLE
            Image.setImageResource(R.drawable.ic_connection_error)
        }
        MovieApiStatus.DONE -> {
            Image.visibility = View.GONE
        }
    }
}
