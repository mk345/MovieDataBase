package com.mk.test.moviedb0k

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

// Manually import this
import com.mk.test.moviedb0k.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    lateinit var movieDBViewModel: MovieDBViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    lateinit var movieList: ArrayList<Movie>

    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        movieDBViewModel = MovieDBViewModel()
        activityMainBinding.movieDBViewModel = movieDBViewModel

        val movieListObserver = Observer<ArrayList<Movie>> { movieList ->
            //Log.e("MKTEST", "CHANGED")

            // RecyclerView
            linearLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = linearLayoutManager
            if (movieList != null) {
                recyclerView.adapter = RecyclerAdapter(movieList, this)
            }
        }
        movieDBViewModel.mutableLiveDatamovieList.observe(this, movieListObserver)

        callWebService()
    }

    fun callWebService() {
        val apiService = ApiInterface.create()
        val call = apiService.getMovieList()
        call.enqueue(object: Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: retrofit2.Response<MovieList>?) {
                if (response != null) {
                    movieList = response.body()?.listOfMovies!!
                    //Log.e("MainActivity", "" + movieList.size)
                    //for (item: Movie in movieList.iterator()) {
                    //    Log.e("MKTEST", item.title)
                    //}
                    movieDBViewModel.mutableLiveDatamovieList.setValue(movieList)

                    //val movieList2: ArrayList<Movie>? = movieDBViewModel.mutableLiveDatamovieList.getValue()
                    //if (movieList2 != null) {
                    //    for (item: Movie in movieList2.iterator()) {
                    //        Log.e("MKTEST", item.title)
                    //    }
                    //}
                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.e("MainActivity", "Failed to connect")
            }
        })
    }

}
