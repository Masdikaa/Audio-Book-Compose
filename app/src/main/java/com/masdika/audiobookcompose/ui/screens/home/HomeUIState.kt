package com.masdika.audiobookcompose.ui.screens.home

sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Success(val data: String) : HomeUIState
    data class Error(val message: String) : HomeUIState
}