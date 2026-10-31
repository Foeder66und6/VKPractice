package com.example.vkpractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vkpractice.data.AppsRepoImpl
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.AppsRepo
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppListViewModel(val apps: AppsRepo) : ViewModel() {

    private val _appList = MutableStateFlow<MutableList<App>>(emptyList<App>().toMutableList())
    val appList: StateFlow<MutableList<App>> = _appList;
    private val _events = Channel<String>()
    val events: Flow<String?> = _events.receiveAsFlow()
    init {

        _appList.value = apps.getApps().toMutableList()
    }
    fun addNaxt(app: App) {
        val trList = MutableList(_appList.value.size, {i: Int -> _appList.value[i]})
        trList.add(apps.getNext(2))

        _appList.update({trList})
    }
    fun sendMessage(message: String) {
        viewModelScope.launch {
            val str = "1"
            _events.send(str)

        }
    }


}

class AppListViewModelFactory(private val apps: AppsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(AppListViewModel::class.java)) {
            return AppListViewModel(apps) as T
        }
        throw IllegalStateException("model class in inassignable")
    }
}