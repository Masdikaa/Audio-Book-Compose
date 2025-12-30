package com.masdika.audiobookcompose.ui.screen.play.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.icon.ArrowBackwardIcon
import com.masdika.audiobookcompose.ui.icon.ArrowForwardIcon
import com.masdika.audiobookcompose.ui.icon.PauseIcon
import com.masdika.audiobookcompose.ui.icon.PlayIcon
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProMedium
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.ui.theme.Night
import com.masdika.audiobookcompose.ui.theme.SmokeWhite

@Composable
fun TrackControl(
    isPlaying: Boolean,
    onPlayTrack: () -> Unit,
    onPauseTrack: () -> Unit,
    onForwardTrack: () -> Unit,
    onBackwardTrack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val onBackground = if (isSystemInDarkTheme()) SmokeWhite else Night

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = onBackwardTrack,
            modifier = Modifier.size(60.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = ArrowBackwardIcon,
                    contentDescription = stringResource(R.string.arrow_backward_icon),
                    tint = onBackground,
                    modifier = Modifier
                        .rotate(-25f)
                        .size(40.dp)
                )
                Text(
                    text = "10",
                    fontSize = 14.sp,
                    fontFamily = GothamProMedium,
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = true
                        ),
                        lineHeightStyle = LineHeightStyle(
                            trim = LineHeightStyle.Trim.Both,
                            alignment = LineHeightStyle.Alignment.Center,
                        )
                    ),
                    color = onBackground
                )
            }
        }
        IconButton(
            onClick = if (isPlaying) onPauseTrack else onPlayTrack,
            modifier = Modifier.size(100.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(onBackground)
            ) {
                Icon(
                    imageVector = if (isPlaying) PauseIcon else PlayIcon,
                    contentDescription = stringResource(R.string.play_and_pause_icon),
                    tint = if (isSystemInDarkTheme()) Night else SmokeWhite,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        IconButton(
            onClick = onForwardTrack,
            modifier = Modifier.size(60.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = ArrowForwardIcon,
                    contentDescription = stringResource(R.string.arrow_forward_icon),
                    tint = onBackground,
                    modifier = Modifier
                        .rotate(25f)
                        .size(40.dp)
                )
                Text(
                    text = "10",
                    fontSize = 14.sp,
                    fontFamily = GothamProMedium,
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = true
                        ),
                        lineHeightStyle = LineHeightStyle(
                            trim = LineHeightStyle.Trim.Both,
                            alignment = LineHeightStyle.Alignment.Center,
                        )
                    ),
                    color = onBackground
                )
            }
        }
    }
}

@Preview
@Composable
private fun TrackControlPreview() {
    AudioBookComposeTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(JeansBlue)
                .padding(20.dp)
        ) {
            TrackControl(
                isPlaying = false,
                onPlayTrack = {},
                onPauseTrack = {},
                onForwardTrack = {},
                onBackwardTrack = {}
            )
        }
    }
}