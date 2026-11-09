package com.example.vkpractice.data

import retrofit2.http.GET
import retrofit2.http.Path

interface AppAPI {

    @GET("/catalog")
    suspend fun getApps() : List<AppAPIDTO>

    @GET("/catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String) : DetailedAppAPIDTO
}