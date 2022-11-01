package com.example.composeplay.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

class AppDetailsViewModel : ViewModel() {

    fun getAppInfo(): StateFlow<AppInfo> {
        return flowOf(gitHubInfo)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyInfo
            )
    }
}