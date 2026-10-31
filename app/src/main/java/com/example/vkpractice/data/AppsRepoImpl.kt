package com.example.vkpractice.data

import com.example.vkpractice.R
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.AppsRepo
import java.util.Random

class AppsRepoImpl(val dataSource: SimpleDataSource, val mapper: AppMapper) : AppsRepo {



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

    override fun getApps() : List<App> {
        val rand = Random();
        val size = rand.nextInt(20)
        val trList = MutableList<AppDTO>(size, { i: Int -> dataSource.getCatalogue()[rand.nextInt(dataSource.getCatalogue().size)]})
        return trList.map({el: AppDTO -> mapper.fromDTO(el)})
    }
    override fun getNext(index: Int) : App {
        return mapper.fromDTO(dataSource.getCatalogue()[index % dataSource.getCatalogue().size])
    }
}