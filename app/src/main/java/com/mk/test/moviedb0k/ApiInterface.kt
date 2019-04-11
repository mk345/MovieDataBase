package com.mk.test.moviedb0k

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("?API_KEY_REMOVED&language=en-US&page=1")
    abstract fun getMovieList(): Call<MovieList>

    companion object RetrofitFactory {
        val BASE_URL = "https://api.themoviedb.org/3/movie/upcoming/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}