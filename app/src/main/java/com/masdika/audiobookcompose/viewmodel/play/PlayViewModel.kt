package com.masdika.audiobookcompose.viewmodel.play

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.audiobookcompose.data.dummy.audioBookList
import com.masdika.audiobookcompose.data.repository.AudioBookRepository
import com.masdika.audiobookcompose.data.repository.HistoryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<PlayUIState>(PlayUIState.Loading)
    val uiState = _uiState.asStateFlow()
    private val _playedDuration = MutableStateFlow(0L)
    val playedDuration = _playedDuration.asStateFlow()
    private val _isPlaying = MutableStateFlow(true)
    val isPlaying = _isPlaying.asStateFlow()
    private var playbackJob: Job? = null
    private val audioBookId: String = checkNotNull(savedStateHandle["audioBookId"])

    init {
        val history = HistoryRepository.getHistoryForBook(audioBookId)
        _playedDuration.value = history?.lastPlayedPositionInSeconds ?: 0L

        getAudioBookById(audioBookId)
        startPlayback()
    }

    fun getAudioBookById(audioBookId: String) {
        viewModelScope.launch {
            try {
                val audioBook = AudioBookRepository.getAudioBookById(audioBookId)
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

    fun onSliderPositionChanged(newPosition: Float) {
        _playedDuration.value = newPosition.toLong()
        if (_isPlaying.value) {
            startPlayback()
        }
    }

    fun play() {
        if (_isPlaying.value) return
        _isPlaying.value = true
        startPlayback()
    }

    fun pause() {
        _isPlaying.value = false
        playbackJob?.cancel()
    }

    private fun startPlayback() {
        playbackJob?.cancel()
        playbackJob = viewModelScope.launch {
            val currentAudioBook = (_uiState.value as? PlayUIState.Success)?.audioBook
            currentAudioBook?.let { book ->
                var currentPosition = _playedDuration.value
                while (_isPlaying.value && currentPosition < book.totalDuration) {
                    delay(1000L)
                    currentPosition++
                    _playedDuration.value = currentPosition
                }
                if (currentPosition >= book.totalDuration) {
                    pause()
                    _playedDuration.value = 0L
                }
            }
        }
    }

    fun forwardBy(seconds: Long) {
        val currentAudioBook = (_uiState.value as? PlayUIState.Success)?.audioBook ?: return
        val newDuration =
            (_playedDuration.value + seconds).coerceAtMost(currentAudioBook.totalDuration)
        _playedDuration.value = newDuration
        if (_isPlaying.value) {
            startPlayback()
        }
    }

    fun rewindBy(seconds: Long) {
        val newDuration = (_playedDuration.value - seconds).coerceAtLeast(0)
        _playedDuration.value = newDuration
        if (_isPlaying.value) {
            startPlayback()
        }
    }

    fun addToBookmark() {
        val audioBook = audioBookList.find { it.id == audioBookId }
        Log.i("onAddBookmark", "Added ${audioBook?.title} to bookmark")
    }

    fun addToPlaylist() {
        val audioBook = audioBookList.find { it.id == audioBookId }
        Log.i("onAddPlaylist", "Added ${audioBook?.title} to playlist")
    }

    fun openVolumeControl() {
        Log.i("onOpenVolumeControl", "Opened volume control")
    }

    override fun onCleared() {
        super.onCleared()
        playbackJob?.cancel()
        HistoryRepository.updatePlayHistory(
            bookId = audioBookId,
            currentPosition = _playedDuration.value
        )
    }
}