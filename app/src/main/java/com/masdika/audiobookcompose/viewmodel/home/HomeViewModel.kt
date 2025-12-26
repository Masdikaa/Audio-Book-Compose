package com.masdika.audiobookcompose.viewmodel.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masdika.audiobookcompose.data.model.AudioBook
import com.masdika.audiobookcompose.data.model.RecentlyPlayedUi
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.data.repository.HistoryRepository
import com.masdika.audiobookcompose.data.repository.HistoryRepository.updatePlayHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

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

    val searchResults: StateFlow<List<AudioBook>> = searchQuery
        .map { query ->
            if (query.isBlank()) {
                audioBookList
            } else {
                audioBookList.filter {
                    it.title.contains(query, ignoreCase = true) || it.author.contains(
                        query,
                        ignoreCase = true
                    )
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = audioBookList
        )

    init {
        loadAudioBooks()
    }

    fun loadAudioBooks() {
        _uiState.update { HomeUIState.Success(audioBookList) }
    }

    fun onAudioBookClicked(bookId: String) {
        val simulatedPlayPosition = 60L
        updatePlayHistory(
            bookId = bookId,
            currentPosition = simulatedPlayPosition
        )
    }

    fun onSearchItemClicked(bookId: String) {
        val simulatedPlayPosition = 60L
        updatePlayHistory(
            bookId = bookId,
            currentPosition = simulatedPlayPosition
        )
    }

    fun onSearchCloseClicked() {
        _isSearching.value = false
        _searchQuery.value = ""
    }

    fun onSearchIconClicked() {
        _isSearching.value = true
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }
}