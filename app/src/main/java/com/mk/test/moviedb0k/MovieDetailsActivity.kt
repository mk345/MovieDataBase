package com.mk.test.moviedb0k

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class MovieDetailsActivity: AppCompatActivity() {

    val BASE_URL = "https://image.tmdb.org/t/p/w500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val imageURL: String = BASE_URL + intent.getStringExtra("imageURL")

        val image: ImageView = findViewById(R.id.movieImage)
        val title: TextView = findViewById(R.id.title)
        val releaseDate: TextView = findViewById(R.id.release_date)
        val popularity: TextView = findViewById(R.id.popularity)
        val voteCount: TextView = findViewById(R.id.votes_count)
        val id: TextView = findViewById(R.id.identifier)
        val video: TextView = findViewById(R.id.video)
        val adult: TextView = findViewById(R.id.adult)
        val overview: TextView = findViewById(R.id.overview)

        if (imageURL != null) {
            ImageAsyncTask(image, imageURL).execute()
        }

        title.text = intent.getStringExtra("title")
        releaseDate.text = intent.getStringExtra("releaseDate")
        popularity.text = intent.getDoubleExtra("popularity", 0.0).toString()
        voteCount.text = intent.getIntExtra("voteCount", 0).toString()
        id.text = intent.getIntExtra("id", 0).toString()
        video.text = intent.getBooleanExtra("video", false).toString()
        adult.text = intent.getBooleanExtra("adult", false).toString()
        overview.text = intent.getStringExtra("overview")
    }
}