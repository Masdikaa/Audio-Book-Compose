package com.masdika.audiobookcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masdika.audiobookcompose.ui.screen.home.HomeScreen
import com.masdika.audiobookcompose.viewmodel.home.HomeVIewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier
    ) {
        composable<Screen.Home> {
            val viewModel = viewModel<HomeVIewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val recentlyPlayed by viewModel.recentlyPlayedState.collectAsState()

            HomeScreen(
                uiState = uiState,
                recentlyPlayed = recentlyPlayed,
                onAudioBookClicked = { bookId -> viewModel.onAudioBookClicked(bookId) },
                onSearchIconClicked = {},
                onNavigateToHome = {},
                onNavigateToMenu = {},
                onNavigateToProfile = {},
            )
        }
    }
}