package com.mk.test.moviedb0k

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_movie.view.*

class RecyclerAdapter(val items: ArrayList<Movie>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>() {

    val BASE_URL = "https://image.tmdb.org/t/p/w500"

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val imageURL = BASE_URL + items.get(position).imageURL

        val mImageView = holder?.ivMovieImage
        if (imageURL != null) {
            ImageAsyncTask(mImageView, imageURL).execute()
        }

        holder?.tvTitle?.text = items.get(position).title
        holder?.tvReleaseDate?.text = items.get(position).releaseDate
        holder?.tvPopularity?.text = items.get(position).popularity.toString()
        holder?.tvVotesCount?.text = items.get(position).voteCount.toString()

        holder?.cdCardView.setOnClickListener() {v ->
            //Log.e("MKTEST", "card clicked with position: " + position)
            val intent = Intent(context, MovieDetailsActivity::class.java)

            val movie = items.get(position)

            intent.putExtra("title", movie.title)
            intent.putExtra("releaseDate", movie.releaseDate)
            intent.putExtra("popularity", movie.popularity)
            intent.putExtra("voteCount", movie.voteCount)
            intent.putExtra("imageURL", movie.imageURL)
            intent.putExtra("id", movie.id)
            intent.putExtra("video", movie.video)
            intent.putExtra("adult", movie.adult)
            intent.putExtra("overview", movie.overview)

            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    class MovieViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val cdCardView = view.card_view
        val ivMovieImage = view.movieImage
        val tvTitle = view.title
        val tvReleaseDate = view.release_date
        val tvPopularity = view.popularity
        val tvVotesCount = view.votes_count
    }

}