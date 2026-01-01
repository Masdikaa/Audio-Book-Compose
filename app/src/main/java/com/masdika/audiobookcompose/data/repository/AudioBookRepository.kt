package com.masdika.audiobookcompose.data.repository

import com.masdika.audiobookcompose.data.dummy.audioBookList
import com.masdika.audiobookcompose.data.model.AudioBook

object AudioBookRepository {
    val audioBooks = audioBookList
    fun getAudioBookById(id: String): AudioBook? {
        return audioBooks.find { audioBook ->
            audioBook.id == id
        }
    }
}