package com.example.vkpractice.data

import android.graphics.Bitmap
import com.example.vkpractice.R
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.DetailedApp
import com.example.vkpractice.presentation.DetailsScreenState

class AppMapper {

    fun fromDTO(appDTO: AppDTO) : App {
        return App( appDTO.name, appDTO.category, appDTO.descr, appDTO.icon, "cool_id")
    }
    fun fromAPIDTO(appAPI: AppAPIDTO) : App {
        return appAPI.run({App(name, category, description, R.drawable.running, id)})
    }
    fun toDetailedApp(detailedAppAPI: DetailedAppAPIDTO, icon: Bitmap, screenshots: List<Bitmap>) : DetailedApp {
        return detailedAppAPI.run({ DetailedApp(name, icon, developer, category, size, ageRating, screenshots, description) })
    }

}