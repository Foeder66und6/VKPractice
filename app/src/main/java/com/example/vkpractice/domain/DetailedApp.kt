package com.example.vkpractice.domain

import android.graphics.Bitmap

data class DetailedApp(val title: String, val icon: Bitmap, val developer: String, val category: String, val size: Float, val ageRating: Int, val screenshots: List<Bitmap>, val description: String )