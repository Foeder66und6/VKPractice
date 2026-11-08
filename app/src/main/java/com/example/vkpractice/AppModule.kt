package com.example.vkpractice

import com.example.vkpractice.data.AppMapper
import com.example.vkpractice.data.AppsRepoImpl
import com.example.vkpractice.data.SimpleDataSource
import com.example.vkpractice.domain.AppsRepo
import com.example.vkpractice.presentation.AppListViewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel

val appModule = module {
    single<AppMapper>() bind AppMapper::class
    single<SimpleDataSource>() bind SimpleDataSource::class
    single<AppsRepoImpl>() bind AppsRepo::class
    viewModel<AppListViewModel>()
}