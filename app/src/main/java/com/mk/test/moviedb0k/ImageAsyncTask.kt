package com.mk.test.moviedb0k

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.SystemClock.sleep
import android.widget.ImageView
import java.io.InputStream

class ImageAsyncTask(private val imageView: ImageView, val mImageURL: String): AsyncTask<Void, Void, Bitmap>() {

    override fun doInBackground(vararg voids: Void): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val inputStream: InputStream = java.net.URL(mImageURL).openStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch(e: Exception) {
            android.util.Log.e("Error", e.message)
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap) {
        imageView.setImageBitmap(result)
    }
}