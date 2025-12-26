package com.masdika.audiobookcompose.data.repository

import com.masdika.audiobookcompose.data.model.PlayHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object HistoryRepository {
    private val _recentlyPlayed = MutableStateFlow<PlayHistory?>(null)
    val recentlyPlayed: StateFlow<PlayHistory?> = _recentlyPlayed.asStateFlow()

    fun updatePlayHistory(bookId: String, currentPosition: Long) {
        _recentlyPlayed.update {
            PlayHistory(
                audioBookId = bookId,
                lastPlayedPositionInSeconds = currentPosition,
                lastPlayedTimestamp = System.currentTimeMillis()
            )
        }
    }
}
