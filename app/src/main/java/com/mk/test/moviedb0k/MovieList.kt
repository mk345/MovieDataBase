package com.mk.test.moviedb0k

import com.google.gson.annotations.SerializedName

class MovieList {
    @SerializedName("results")
    var listOfMovies: ArrayList<Movie>? = null
}