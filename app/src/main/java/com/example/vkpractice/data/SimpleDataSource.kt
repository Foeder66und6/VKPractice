package com.example.vkpractice.data

import com.example.vkpractice.R

class SimpleDataSource {

    private val appCatalogue = listOf(
        AppDTO(
            "Magical forest guide",
            "The most complete collection of information about magical forests",
            "trevelling",
            R.drawable.forest,
            4.99f
        ),
        AppDTO("Sleep manager", "Application for tracking your sleep", "health", R.drawable.sleep, 4.98f),
        AppDTO(
            "Nutrition manager",
            "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions",
            "health",
            R.drawable.looking,
            4.97f
        )
    )

    fun getCatalogue() = appCatalogue
}