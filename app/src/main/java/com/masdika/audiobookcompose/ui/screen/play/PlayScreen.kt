package com.masdika.audiobookcompose.ui.screen.play

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.screen.play.component.AudioBookTitle
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
    sliderPositions: Float,
    isPlaying: Boolean,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is PlayUIState.Success -> {

            val audioBook = uiState.audioBook

            PlayScreenContent(
                title = audioBook.title,
                author = audioBook.author,
                totalDuration = audioBook.totalDuration,
                sliderPosition = sliderPositions,
                isPlaying = isPlaying,
                onPlay = onPlay,
                onPause = onPause,
                image = audioBook.imageID,
                modifier = modifier
            )
        }

        is PlayUIState.Loading -> {}
        is PlayUIState.Error -> {}
    }
}

@Composable
fun PlayScreenContent(
    title: String,
    author: String,
    totalDuration: Long,
    sliderPosition: Float,
    isPlaying: Boolean,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    modifier: Modifier = Modifier,
    playedDuration: Long = 0L,
    image: Int = R.drawable.ic_launcher_background
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(JeansBlue)
                .padding(innerPadding)
        ) {
            Header(modifier = Modifier.padding(horizontal = 20.dp))
            PlayedImage(
                imageId = image,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(20.dp))
            TrackSlider(
                sliderPosition = sliderPosition,
                totalDuration = totalDuration,
                playedDuration = playedDuration,
                onSliderPositionChanged = {  },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.fillMaxHeight(0.08f))
            AudioBookTitle(
                title = title,
                author = author,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(Modifier.fillMaxHeight(0.15f))
            TrackControl(
                isPlaying = isPlaying,
                onPlayTrack = onPlay,
                onPauseTrack = onPause
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        JeansBlue.copy(
                            red = 195f / 255f,
                            green = 224f / 255f,
                            blue = 232f / 255f
                        )
                    )
            ) { }
        }
    }
}

@Preview(
    name = "Play Screen Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "PLay Screen Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PlayScreenPreview() {
    AudioBookComposeTheme {
        PlayScreenContent(
            title = "City of Girls",
            author = "Elizabeth Gilbert",
            playedDuration = 41821L,
            totalDuration = 42000L,
            sliderPosition = 3f,
            isPlaying = false,
            onPlay = {},
            onPause = {},
            image = R.drawable.city_of_girls_elizabeth_gilbert
        )
    }
}