package com.masdika.audiobookcompose.ui.screen.play.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProRegular
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.ui.theme.Night
import com.masdika.audiobookcompose.utils.formatDuration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackSlider(
    totalDuration: Long,
    onSliderPositionChanged: (Float) -> Unit,
    modifier: Modifier = Modifier,
    playedDuration: Long
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Slider(
            value = playedDuration.toFloat(),
            onValueChange = { newPosition ->
                onSliderPositionChanged(newPosition)
            },
            valueRange = 0f..totalDuration.toFloat(),
            track = { sliderState ->
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                ) {
                    val range = sliderState.valueRange.endInclusive - sliderState.valueRange.start
                    val fraction = if (range > 0) {
                        (sliderState.value - sliderState.valueRange.start) / range
                    } else {
                        0f
                    }
                    val activeWidth = size.width * fraction

                    drawLine(
                        color = Color.White.copy(0.6f),
                        start = Offset(0f, center.y),
                        end = Offset(size.width, center.y),
                        strokeWidth = size.height,
                        cap = StrokeCap.Butt
                    )

                    drawLine(
                        color = Night,
                        start = Offset(0f, center.y),
                        end = Offset(activeWidth, center.y),
                        strokeWidth = size.height,
                        cap = StrokeCap.Butt
                    )
                }
            },
            thumb = {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Night)
                )
            },
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = formatDuration(playedDuration),
                fontSize = 16.sp,
                fontFamily = GothamProRegular,
                fontWeight = FontWeight.Bold,
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
            Text(
                text = formatDuration(totalDuration),
                fontSize = 16.sp,
                fontFamily = GothamProRegular,
                fontWeight = FontWeight.Bold,
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
private fun TrackSliderPreview() {
    AudioBookComposeTheme {
        TrackSlider(
            totalDuration = 10000,
            playedDuration = 2000,
            onSliderPositionChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(JeansBlue)
                .padding(horizontal = 20.dp)
        )
    }
}