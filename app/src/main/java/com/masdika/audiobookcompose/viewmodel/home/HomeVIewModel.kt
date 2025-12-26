package com.masdika.audiobookcompose.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.audiobookcompose.data.model.RecentlyPlayedUi
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.data.repository.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

// import android.app.Application
// application: Application
class HomeVIewModel() : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()

    val recentlyPlayedState: StateFlow<RecentlyPlayedUi?> =
        HistoryRepository.recentlyPlayed
            .map { playHistory ->
                playHistory?.let {
                    val audioBook = audioBookList.find { book -> book.id == it.audioBookId }
                    audioBook?.let { book ->
                        RecentlyPlayedUi(
                            title = book.title,
                            author = book.author,
                            imageId = book.imageID,
                            remainingDuration = book.totalDuration - it.lastPlayedPositionInSeconds
                        )
                    }
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )


    init {
        loadAudioBooks()
    }

    fun loadAudioBooks() {
        _uiState.update { HomeUIState.Success(audioBookList) }
    }

    fun onAudioBookClicked(bookId: String) {
        val simulatedPlayPosition = 60L
        HistoryRepository.updatePlayHistory(bookId, simulatedPlayPosition)
    }
}