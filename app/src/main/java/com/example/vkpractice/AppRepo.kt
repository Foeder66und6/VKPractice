package com.example.vkpractice

class AppRepo {

    val appCatalogue = listOf(App("Magical forest guide", "trevelling", "The most complete collection of information about magical forests",R.drawable.forest), App("Sleep manager", "health", "Application for tracking your sleep", R.drawable.sleep), App("Nutrition manager", "health", "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions", R.drawable.looking))

    fun getNext(app: App) : App {
        return appCatalogue[(appCatalogue.indexOf(app) + 1) % appCatalogue.size]//.find(app)
    }
}