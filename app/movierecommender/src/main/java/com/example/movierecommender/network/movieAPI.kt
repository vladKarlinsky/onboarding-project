package com.example.movierecommender.network

import com.example.movierecommender.model.SearchResponseMovies
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.themoviedb.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface movieAPI {

    @GET("3/search/movie?" +
            "api_key=7ad79a1981d86b8bd5a35226e046f626")
    fun getMoviesSearch(@Query("query") query: String): Call<SearchResponseMovies>
}
object MovieApi {
    val retrofitService : movieAPI by lazy {
        retrofit.create(movieAPI::class.java) }
}