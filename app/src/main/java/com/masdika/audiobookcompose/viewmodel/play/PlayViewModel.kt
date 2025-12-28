package com.masdika.audiobookcompose.viewmodel.play

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.audiobookcompose.data.model.audioBookList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<PlayUIState>(PlayUIState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _sliderPosition = MutableStateFlow(0f)
    val sliderPosition = _sliderPosition.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying = _isPlaying.asStateFlow()

    private val audioBookId: String = checkNotNull(savedStateHandle["audioBookId"])

    init {
        getAudioBookById(audioBookId)
    }

    fun getAudioBookById(audioBookId: String) {
        viewModelScope.launch {
            try {
                val audioBook = audioBookList.find { it.id == audioBookId }
                if (audioBook != null) {
                    _uiState.update { PlayUIState.Success(audioBook) }
                } else {
                    _uiState.update { PlayUIState.Error("Audiobook not found!") }
                }
            } catch (e: Exception) {
                _uiState.update { PlayUIState.Error(e.message ?: "An unexpected error occurred.") }
            }
        }
    }

    fun play() {
        _isPlaying.value = true
    }

    fun pause() {
        _isPlaying.value = false
    }

}