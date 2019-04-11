package com.mk.test.moviedb0k

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MovieDBViewModel: ViewModel() {

    //lateinit var movieList: ArrayList<Movie>

    val mutableLiveDatamovieList: MutableLiveData<ArrayList<Movie>> by lazy {
        MutableLiveData<ArrayList<Movie>>()
    }

    // Test code
    var someText = "Movie Listings"

    var someText2 = ObservableField(someText)

    fun changeText() {
        someText = someText + "Changed"
        someText2.set(someText)
    }

}