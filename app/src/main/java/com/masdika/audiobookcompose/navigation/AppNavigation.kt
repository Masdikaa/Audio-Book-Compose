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
import com.masdika.audiobookcompose.viewmodel.home.HomeViewModel

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
            val viewModel = viewModel<HomeViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val recentlyPlayed by viewModel.recentlyPlayedState.collectAsState()
            val isSearching by viewModel.isSearching.collectAsState()
            val searchQuery by viewModel.searchQuery.collectAsState()
            val searchResults by viewModel.searchResults.collectAsState()

            HomeScreen(
                uiState = uiState,
                recentlyPlayed = recentlyPlayed,
                searchQuery = searchQuery,
                isSearching = isSearching,
                searchResults = searchResults,
                onSearchCloseClicked = viewModel::onSearchCloseClicked,
                onAudioBookClicked = viewModel::onAudioBookClicked,
                onSearchIconClicked = viewModel::onSearchIconClicked,
                onNavigateToHome = {},
                onNavigateToMenu = {},
                onNavigateToProfile = {},
                onSearchQueryChanged = viewModel::onSearchQueryChanged,
                onSearchItemClicked = viewModel::onSearchItemClicked,
            )
        }
    }
}