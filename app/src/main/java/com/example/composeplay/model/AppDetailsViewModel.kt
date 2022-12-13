package com.example.composeplay.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AppDetailsViewModel : ViewModel() {

    fun getAppInfo(): StateFlow<AppInfo> {
        return flowOf(gitHubInfo)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyAppInfo
            )
    }

    fun getAppDetails(): StateFlow<AppDetails> {
        return flowOf(gitHubAppDetails)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyAppDetails
            )
    }

    fun getAppScreenshot(): StateFlow<List<Int>> {
        return flowOf(gitHubInfo)
            .map { it.screenshotRes }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )
    }
}