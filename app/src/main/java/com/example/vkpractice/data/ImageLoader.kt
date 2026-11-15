package com.example.vkpractice.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.vkpractice.R
import java.net.URL

class ImageLoader {
    fun loadImage(url: String) : Bitmap {
        //var image: Bitmap = BitmapFactory.//.decodeResource(get, R.drawable.running)//?
        val inStream = URL(url).openStream()
        return BitmapFactory.decodeStream(inStream)//is
    }
}