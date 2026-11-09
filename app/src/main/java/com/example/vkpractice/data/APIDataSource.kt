package com.example.vkpractice.data

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIDataSource {
    private val retro = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://185.103.109.134").build()
    val api = retro.create(AppAPI::class.java)
}