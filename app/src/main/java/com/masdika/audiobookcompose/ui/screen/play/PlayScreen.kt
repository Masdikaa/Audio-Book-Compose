package com.masdika.audiobookcompose.ui.screen.play

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.ui.screen.play.component.AudioBookTitle
import com.masdika.audiobookcompose.ui.screen.play.component.BottomControl
import com.masdika.audiobookcompose.ui.screen.play.component.Header
import com.masdika.audiobookcompose.ui.screen.play.component.PlayedImage
import com.masdika.audiobookcompose.ui.screen.play.component.TrackControl
import com.masdika.audiobookcompose.ui.screen.play.component.TrackSlider
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.viewmodel.play.PlayUIState

@Composable
fun PlayScreen(
    uiState: PlayUIState,
    playedDuration: Long,
    isPlaying: Boolean,
    onSliderPositionChanged: (Float) -> Unit,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    onAddBookmark: () -> Unit,
    onAddPlaylist: () -> Unit,
    onOpenVolumeControl: () -> Unit,
    onForwardTrack: () -> Unit,
    onBackwardTrack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val background = if (isSystemInDarkTheme()) {
        JeansBlue.copy(
            red = 45f / 255f,
            green = 65f / 255f,
            blue = 100f / 255f
        )
    } else {
        JeansBlue
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        bottomBar = {
            if (uiState is PlayUIState.Success) {
                BottomControl(
                    onAddBookmark = onAddBookmark,
                    onAddPlaylist = onAddPlaylist,
                    onOpenVolumeControl = onOpenVolumeControl,
                )
            }
        }
    ) { innerPadding ->

        when (uiState) {
            is PlayUIState.Success -> {
                val audioBook = uiState.audioBook

                PlayScreenContent(
                    title = audioBook.title,
                    author = audioBook.author,
                    totalDuration = audioBook.totalDuration,
                    playedDuration = playedDuration,
                    isPlaying = isPlaying,
                    onSliderPositionChanged = onSliderPositionChanged,
                    onPlay = onPlay,
                    onPause = onPause,
                    onForwardTrack = onForwardTrack,
                    onBackwardTrack = onBackwardTrack,
                    image = audioBook.imageID,
                    modifier = modifier.padding(innerPadding)
                )
            }

            is PlayUIState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    CircularProgressIndicator()
                }
            }

            is PlayUIState.Error -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Text("Unable to load data")
                }
            }
        }
    }
}

@Composable
fun PlayScreenContent(
    title: String,
    author: String,
    totalDuration: Long,
    playedDuration: Long,
    isPlaying: Boolean,
    onSliderPositionChanged: (Float) -> Unit,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    onForwardTrack: () -> Unit,
    onBackwardTrack: () -> Unit,
    modifier: Modifier = Modifier,
    image: Int = R.drawable.ic_launcher_background
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxSize()
    ) {
        Header(modifier = Modifier.padding(horizontal = 20.dp))
        PlayedImage(
            imageId = image,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(20.dp))
        TrackSlider(
            totalDuration = totalDuration,
            playedDuration = playedDuration,
            onSliderPositionChanged = onSliderPositionChanged,
            modifier = Modifier.padding(horizontal = 11.dp)
        )
        Spacer(Modifier.fillMaxHeight(0.1f))
        AudioBookTitle(
            title = title,
            author = author,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        TrackControl(
            isPlaying = isPlaying,
            onPlayTrack = onPlay,
            onPauseTrack = onPause,
            onForwardTrack = onForwardTrack,
            onBackwardTrack = onBackwardTrack
        )
    }
}

@Preview(
    name = "Play Screen Success Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "PLay Screen Success Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PlayScreenSuccessPreview() {
    AudioBookComposeTheme {
        val audioBook = audioBookList.first()
        PlayScreen(
            uiState = PlayUIState.Success(audioBook),
            playedDuration = 50000L,
            isPlaying = false,
            onSliderPositionChanged = {},
            onPlay = {},
            onPause = {},
            onAddBookmark = {},
            onAddPlaylist = {},
            onOpenVolumeControl = {},
            onForwardTrack = {},
            onBackwardTrack = {}
        )
    }
}

@Preview(
    name = "Play Screen Loading Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "PLay Screen Loading Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PlayScreenLoadingPreview() {
    AudioBookComposeTheme {
        PlayScreen(
            uiState = PlayUIState.Loading,
            playedDuration = 50000L,
            isPlaying = false,
            onSliderPositionChanged = {},
            onPlay = {},
            onPause = {},
            onAddBookmark = {},
            onAddPlaylist = {},
            onOpenVolumeControl = {},
            onForwardTrack = {},
            onBackwardTrack = {}
        )
    }
}

@Preview(
    name = "Play Screen Error Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "PLay Screen Error Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PlayScreenErrorPreview() {
    AudioBookComposeTheme {
        PlayScreen(
            uiState = PlayUIState.Error("Unable to load data"),
            playedDuration = 50000L,
            isPlaying = false,
            onSliderPositionChanged = {},
            onPlay = {},
            onPause = {},
            onAddBookmark = {},
            onAddPlaylist = {},
            onOpenVolumeControl = {},
            onForwardTrack = {},
            onBackwardTrack = {}
        )
    }
}