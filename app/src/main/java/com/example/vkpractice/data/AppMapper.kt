package com.example.vkpractice.data

import com.example.vkpractice.R
import com.example.vkpractice.domain.App

class AppMapper {

    fun fromDTO(appDTO: AppDTO) : App {
        return App( appDTO.name, appDTO.category, appDTO.descr, appDTO.icon, "cool_id")
    }
    fun fromAPIDTO(appAPI: AppAPIDTO) : App {
        return appAPI.run({App(name, category, description, R.drawable.running, id)})
    }

}