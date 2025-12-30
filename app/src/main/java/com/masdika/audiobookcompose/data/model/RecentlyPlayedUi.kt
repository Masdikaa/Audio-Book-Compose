package com.masdika.audiobookcompose.data.model

import kotlinx.serialization.Serializable
@Serializable
data class RecentlyPlayedUi(
    val id: String,
    val title: String,
    val author: String,
    val imageId: Int,
    val remainingDuration: Long
)
