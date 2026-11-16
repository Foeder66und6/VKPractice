package com.example.vkpractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.compose.setSingletonImageLoaderFactory
import com.example.vkpractice.domain.AppsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Random

class AppDetailsViewModel(val appsRepo: AppsRepo) : ViewModel() {
    private val _appDetails = MutableStateFlow<DetailsScreenState>(DetailsScreenState.DetailsEmpty)

    val appDetails: StateFlow<DetailsScreenState> = _appDetails

    private val _loadingState = MutableStateFlow<Float>(-1.0f)
    val loadingState: StateFlow<Float> = _loadingState
    private var loadingJob: Job? = null

    fun getDetails(id: String) {
        viewModelScope.launch {
            val details = appsRepo.loadDetails(id)
            _appDetails.value = DetailsScreenState.DetailsContent(details, "download")
        }
    }
    fun onLoadClick() {
        if (_appDetails.value !is DetailsScreenState.DetailsContent) {
            return
        }
        val app = (_appDetails.value as DetailsScreenState.DetailsContent).details
        if (_loadingState.value < 0.0f && loadingJob == null) {
            val loader = Random()
//
            loadingJob = viewModelScope.launch(Dispatchers.IO) {
                while (_loadingState.value < app.size) {
                      delay( 500 + loader.nextInt(200).toLong())
                      _loadingState.value += loader.nextInt(30) / 10.0f
                }
                if (_loadingState.value > app.size) {
                    _loadingState.value = app.size
                }
            }
            return
        }
        if (0.0 <= _loadingState.value && _loadingState.value < app.size ) {
            loadingJob?.cancel()
            loadingJob = null
            _loadingState.value = -1.0f
        }
    }

}