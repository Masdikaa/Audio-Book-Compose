package com.masdika.audiobookcompose.viewmodel.play

import com.masdika.audiobookcompose.data.model.AudioBook

sealed interface PlayUIState {
    object Loading : PlayUIState
    data class Success(val audioBook: AudioBook) : PlayUIState
    data class Error(val message: String) : PlayUIState
}