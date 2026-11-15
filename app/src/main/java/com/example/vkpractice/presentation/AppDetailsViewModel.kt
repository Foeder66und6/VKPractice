package com.example.vkpractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkpractice.domain.AppsRepo
import com.example.vkpractice.domain.DetailsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(val appsRepo: AppsRepo) : ViewModel() {
    private val _appDetails = MutableStateFlow<DetailsScreenState>(DetailsScreenState.DetailsEmpty)
    val appDetails: StateFlow<DetailsScreenState> = _appDetails

    fun getDetails(id: String) {
        viewModelScope.launch {
            val details = appsRepo.loadDetails(id)// appsRepo.
            _appDetails.value = details//.s
        }
    }
//App
}