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
import com.masdika.audiobookcompose.ui.screen.play.PlayScreen
import com.masdika.audiobookcompose.viewmodel.home.HomeViewModel
import com.masdika.audiobookcompose.viewmodel.play.PlayViewModel

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
            val audioBooks by viewModel.audioBooks.collectAsState()
            val selectedGenreIndex by viewModel.selectedGenreIndex.collectAsState()
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
                audioBooks = audioBooks,
                selectedGenreIndex = selectedGenreIndex,
                onGenreSelected = viewModel::onGenreSelected,
                onAudioBookClicked = { audioBookId ->
                    viewModel.onAudioBookClicked(audioBookId)
                    navController.navigate(Screen.Play(audioBookId))
                },
                onSearchIconClicked = viewModel::onSearchIconClicked,
                onNavigateToHome = viewModel::navigateToHome,
                onNavigateToMenu = viewModel::navigateToMenu,
                onNavigateToProfile = viewModel::navigateToProfile,
                onSearchQueryChanged = viewModel::onSearchQueryChanged,
                onSearchItemClicked = { audioBookId ->
                    viewModel.onSearchItemClicked(audioBookId)
                    navController.navigate(Screen.Play(audioBookId))
                },
            )
        }
        composable<Screen.Play> {
            val viewModel = viewModel<PlayViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val playedDuration by viewModel.playedDuration.collectAsState()
            val isPlaying by viewModel.isPlaying.collectAsState()

            PlayScreen(
                uiState = uiState,
                playedDuration = playedDuration,
                isPlaying = isPlaying,
                onPlay = viewModel::play,
                onPause = viewModel::pause,
                onSliderPositionChanged = viewModel::onSliderPositionChanged,
                onAddBookmark = viewModel::addToBookmark,
                onAddPlaylist = viewModel::addToPlaylist,
                onOpenVolumeControl = viewModel::openVolumeControl,
                onForwardTrack = { viewModel.forwardBy(10) },
                onBackwardTrack = { viewModel.rewindBy(10) },
            )
        }
    }
}
