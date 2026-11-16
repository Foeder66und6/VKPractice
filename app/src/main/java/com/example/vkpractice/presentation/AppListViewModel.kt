package com.example.vkpractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vkpractice.data.AppsRepoImpl
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.AppsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.measureTime

class AppListViewModel(val apps: AppsRepo) : ViewModel() {

    private val _appList = MutableStateFlow<MutableList<App>>(emptyList<App>().toMutableList())

    val appList: StateFlow<MutableList<App>> = _appList;
    private val _events = Channel<String>()
    val events: Flow<String?> = _events.receiveAsFlow()

    private val _ratings = MutableStateFlow<List<Int>>(listOf())
    val ratings: StateFlow<List<Int>> = _ratings
    private val _sequentialTime = MutableStateFlow<Long>(0)
    val sequentialTime: StateFlow<Long> = _sequentialTime
    private val _parallelTime = MutableStateFlow<Long>(0)
    val parallelTime: StateFlow<Long> = _parallelTime
    init {
        viewModelScope.launch {
            _appList.value = apps.getApps().toMutableList()
        }
    }
    fun addNaxt(app: App) {
        val trList = MutableList(_appList.value.size, {i: Int -> _appList.value[i]})
        trList.add(apps.getNext(2))

        _appList.update({trList})
    }
    fun loadRatingsSequentially(ids: List<String>) {

        viewModelScope.launch(Dispatchers.IO) {
            _sequentialTime.value = measureTime({
                _ratings.value = ids.map( {id: String -> apps.loadRating(id)})

            }).inWholeMilliseconds
        }

    }
    fun loadRatingsParallelly(ids: List<String>) {

        viewModelScope.launch(Dispatchers.IO) {
            _parallelTime.value = measureTime({
                _ratings.value = coroutineScope {ids.map({id: String -> async{apps.loadRating(id)}})}.awaitAll()
            }).inWholeMilliseconds
        }

    }
    fun sendMessage(message: String) {
        viewModelScope.launch {
            val str = "1"
            _events.send(str)

        }
    }


}

//class AppListViewModelFactory(private val apps: AppsRepo) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
//        if (modelClass.isAssignableFrom(AppListViewModel::class.java)) {
//            return AppListViewModel(apps) as T
//        }
//        throw IllegalStateException("model class in inassignable")
//    }
//}