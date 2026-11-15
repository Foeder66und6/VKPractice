package com.example.vkpractice.domain

import android.graphics.Bitmap

sealed interface DetailsScreenState {
    object DetailsEmpty : DetailsScreenState
    data class DetailedApp(val title: String, val developer: String, val category: String, val size: Float, val ageRating: Int, val screenshots: List<Bitmap>, val description: String ) : DetailsScreenState
}