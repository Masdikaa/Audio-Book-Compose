package com.masdika.audiobookcompose.ui.screen.play.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.ui.icon.AddIcon
import com.masdika.audiobookcompose.ui.icon.BookmarkIcon
import com.masdika.audiobookcompose.ui.icon.SpeakerIcon
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.ui.theme.Night

@Composable
fun BottomControl(
    onAddBookmark: () -> Unit,
    onAddPlaylist: () -> Unit,
    onOpenVolumeControl: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    JeansBlue.copy(
                        red = 195f / 255f,
                        green = 224f / 255f,
                        blue = 232f / 255f
                    )
                )
        ) {
            IconButton(
                onClick = onAddBookmark,
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = BookmarkIcon,
                    contentDescription = null,
                    tint = Night,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(5.dp)
                )
            }
            IconButton(
                onClick = onAddPlaylist,
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = AddIcon,
                    contentDescription = null,
                    tint = Night,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(5.dp)
                )
            }
            IconButton(
                onClick = onOpenVolumeControl,
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = SpeakerIcon,
                    contentDescription = null,
                    tint = Night,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun BottomControlPreview() {
    AudioBookComposeTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .background(JeansBlue)
        ) {
            BottomControl(
                onAddBookmark = {},
                onAddPlaylist = {},
                onOpenVolumeControl = {}
            )
        }
    }
}