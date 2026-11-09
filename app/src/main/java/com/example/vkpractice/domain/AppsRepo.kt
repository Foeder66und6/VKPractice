package com.example.vkpractice.domain

interface AppsRepo {



    suspend fun getApps() : List<App>
    fun getNext(index: Int) : App
}