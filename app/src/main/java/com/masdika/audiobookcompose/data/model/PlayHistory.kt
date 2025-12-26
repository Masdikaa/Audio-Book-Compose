package com.masdika.audiobookcompose.data.model

data class PlayHistory(
    val audioBookId: String,
    val lastPlayedPositionInSeconds: Long,
    val lastPlayedTimestamp: Long
)
