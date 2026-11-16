package com.example.vkpractice.domain

import com.example.vkpractice.presentation.DetailsScreenState

interface AppsRepo {



    suspend fun getApps() : List<App>
    fun getNext(index: Int) : App
    suspend fun loadDetails(id: String) : DetailedApp
    suspend fun loadRating(id: String) : Int
}