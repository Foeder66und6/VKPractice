package com.example.vkpractice.domain

interface AppsRepo {



    suspend fun getApps() : List<App>
    fun getNext(index: Int) : App
    suspend fun loadDetails(id: String) : DetailsScreenState.DetailedApp
}