package com.mk.test.moviedb0k

import com.google.gson.annotations.SerializedName

/*
class Movie(val title: String,
            val releaseDate: String,
            val popularity: Double,
            val voteCount: Int,
            val imageURL: String,
            val id: Int,
            val video: Boolean,
            val adult: Boolean,
            val overview: String) {

}
*/

class Movie {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("popularity")
    var popularity: Double? = null

    @SerializedName("vote_count")
    var voteCount: Int? = null

    @SerializedName("backdrop_path")
    var imageURL: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("video")
    var video: Boolean? = null

    @SerializedName("adult")
    var adult: Boolean? = null

    @SerializedName("overview")
    var overview: String? = null
}