package com.example.vkpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
//import kotlin.random.Random
import java.util.Random

class AppListViewModel : ViewModel() {
    private val apps = AppRepo()
    private val _appList = MutableStateFlow<MutableList<App>>(apps.appCatalogue.toMutableList())
    val appList: StateFlow<MutableList<App>> = _appList;
    private val _events = Channel<String>()
    val events: Flow<String?> = _events.receiveAsFlow()
    init {
        val rand = Random();
        val size = rand.nextInt(20)
        val trList = MutableList<App>(size, {i: Int -> apps.appCatalogue[rand.nextInt(apps.appCatalogue.size)]})

        _appList.value = trList
    }
    fun addNaxt(app: App) {
        val trList = MutableList(_appList.value.size, {i: Int -> _appList.value[i]})
        trList.add(apps.getNext(app))

        _appList.update({trList})
    }
    fun sendMessage(message: String) {
        viewModelScope.launch {
            val str = "1"
            _events.send(str)

        }
    }


}