package com.example.vkpractice.data

data class DetailedAppAPIDTO(val id: String, val name: String, val developer: String, val category: String, val ageRating: Int, val size: Float, val iconUrl: String, val screenshotUrlList: List<String>, val description: String) {
}