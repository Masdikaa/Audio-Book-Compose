package com.masdika.audiobookcompose.data.repository

import com.masdika.audiobookcompose.data.model.PlayHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

object HistoryRepository {
    private val _playHistoryMap = MutableStateFlow<Map<String, PlayHistory>>(emptyMap())

    val recentlyPlayed: Flow<PlayHistory?> = _playHistoryMap.map { map ->
        map.values.maxByOrNull { it.lastPlayedTimestamp }
    }

    fun updatePlayHistory(bookId: String, currentPosition: Long) {
        _playHistoryMap.update { currentMap ->
            val newHistory = PlayHistory(
                audioBookId = bookId,
                lastPlayedPositionInSeconds = currentPosition,
                lastPlayedTimestamp = System.currentTimeMillis()
            )
            currentMap + (bookId to newHistory)
        }
    }

    fun getHistoryForBook(bookId: String): PlayHistory? {
        return _playHistoryMap.value[bookId]
    }
}
