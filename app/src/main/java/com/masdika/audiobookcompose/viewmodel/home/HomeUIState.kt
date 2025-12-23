package com.masdika.audiobookcompose.viewmodel.home

import com.masdika.audiobookcompose.data.model.AudioBook

sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Success(val audioBooks: List<AudioBook>) : HomeUIState
    data class Error(val message: String) : HomeUIState
}