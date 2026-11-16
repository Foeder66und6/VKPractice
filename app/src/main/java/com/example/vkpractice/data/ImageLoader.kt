package com.example.vkpractice.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.vkpractice.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class ImageLoader {
    suspend fun loadImage(url: String) : Bitmap {

            //"https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"
        var image: Bitmap? = null
        withContext(Dispatchers.IO) {
            val connection = URL(url).openConnection() as HttpsURLConnection
            connection.doInput = true
            connection.connect()
            image = BitmapFactory.decodeStream(BufferedInputStream(connection.getInputStream()))!!
        }


        return image!!
    }
}