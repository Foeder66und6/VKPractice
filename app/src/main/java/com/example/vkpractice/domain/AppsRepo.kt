package com.example.vkpractice.domain

interface AppsRepo {



    fun getApps() : List<App>
    fun getNext(index: Int) : App
}