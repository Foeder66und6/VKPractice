package com.example.vkpractice.presentation

import android.graphics.Bitmap
import com.example.vkpractice.domain.DetailedApp

sealed interface DetailsScreenState {
    object DetailsEmpty : DetailsScreenState
    data class DetailsContent(val details: DetailedApp, val downloadingStatus: String) : DetailsScreenState
}