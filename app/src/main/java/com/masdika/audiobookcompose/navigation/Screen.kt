package com.masdika.audiobookcompose.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data class Play(val audioBookId: String) : Screen
}