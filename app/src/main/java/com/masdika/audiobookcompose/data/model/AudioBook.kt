package com.masdika.audiobookcompose.data.model

data class AudioBook(
    val id: String,
    val title: String,
    val author: String,
    val synopsys: String,
    val rating: Double,
    val genre: List<Genre>,
    val imageID: Int,
    val totalDuration: Long
)