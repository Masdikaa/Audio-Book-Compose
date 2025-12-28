package com.masdika.audiobookcompose.ui.screen.play.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.ui.icon.ArrowBackwardIcon
import com.masdika.audiobookcompose.ui.icon.ArrowForwardIcon
import com.masdika.audiobookcompose.ui.icon.PauseIcon
import com.masdika.audiobookcompose.ui.icon.PlayIcon
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProMedium
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.ui.theme.Night

@Composable
fun TrackControl(
    isPlaying: Boolean,
    onPlayTrack: () -> Unit,
    onPauseTrack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = ArrowBackwardIcon,
                contentDescription = null,
                tint = Night,
                modifier = Modifier.rotate(-25f)
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
                color = Night
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Night)
                .clickable {
                    if (isPlaying) {
                        onPauseTrack()
                    } else {
                        onPlayTrack()
                    }
                }
        ) {
            Icon(
                imageVector = if (isPlaying) PauseIcon else PlayIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = ArrowForwardIcon,
                contentDescription = null,
                tint = Night,
                modifier = Modifier.rotate(25f)
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
                color = Night
            )
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
            )
        }
    }
}