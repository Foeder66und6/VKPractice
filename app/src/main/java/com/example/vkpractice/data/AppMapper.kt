package com.example.vkpractice.data

import com.example.vkpractice.domain.App

class AppMapper {

    fun fromDTO(appDTO: AppDTO) : App {
        return App( appDTO.name, appDTO.category, appDTO.descr, appDTO.icon)
    }

}