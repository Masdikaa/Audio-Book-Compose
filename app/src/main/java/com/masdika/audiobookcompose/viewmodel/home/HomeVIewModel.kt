package com.masdika.audiobookcompose.viewmodel.home

import androidx.lifecycle.ViewModel
import com.masdika.audiobookcompose.data.model.audioBookList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// import android.app.Application
// application: Application
class HomeVIewModel() : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadAudioBooks()
    }

    fun loadAudioBooks() {
        _uiState.update { HomeUIState.Success(audioBookList) }
    }
}