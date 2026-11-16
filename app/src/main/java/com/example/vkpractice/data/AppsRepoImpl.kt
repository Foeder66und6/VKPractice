package com.example.vkpractice.data

import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.AppsRepo
import com.example.vkpractice.domain.DetailedApp
import com.example.vkpractice.presentation.DetailsScreenState

class AppsRepoImpl(val dataSource: SimpleDataSource, val apiDataSource: APIDataSource, val imageLoader: ImageLoader, val mapper: AppMapper) : AppsRepo {



/*
    val appCatalogue = listOf(
        App(
            "Magical forest guide",
            "trevelling",
            "The most complete collection of information about magical forests",
            R.drawable.forest
        ),
        App("Sleep manager", "health", "Application for tracking your sleep", R.drawable.sleep),
        App(
            "Nutrition manager",
            "health",
            "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions",
            R.drawable.looking
        )
    )

 */

    override suspend fun getApps() : List<App> {
        val apps = apiDataSource.api.getApps()
        return apps.map({app -> mapper.fromAPIDTO(app)})
//        val rand = Random();
//        val size = rand.nextInt(20)
//        val trList = MutableList<AppDTO>(size, { i: Int -> dataSource.getCatalogue()[rand.nextInt(dataSource.getCatalogue().size)]})
//        return trList.map({el: AppDTO -> mapper.fromDTO(el)})
    }
    override fun getNext(index: Int) : App {
        return mapper.fromDTO(dataSource.getCatalogue()[index % dataSource.getCatalogue().size])
    }
    override  suspend fun loadDetails(id: String) : DetailedApp {
        val detailedApp = apiDataSource.api.getAppDetails(id)
        val screenshots = detailedApp.screenshotUrlList.map({url: String -> imageLoader.loadImage(url)})
        val icon = imageLoader.loadImage(detailedApp.iconUrl)
        return mapper.toDetailedApp(detailedApp, icon, screenshots)
    }
}