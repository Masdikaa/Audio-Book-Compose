package com.masdika.audiobookcompose.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.Black
import com.masdika.audiobookcompose.ui.theme.GothamProRegular
import com.masdika.audiobookcompose.ui.theme.Transparent
import com.masdika.audiobookcompose.ui.theme.White

@Composable
fun RecentlyPlayedCard(
    author: String,
    hourLeft: Int,
    minuteLeft: Int,
    backgroundImage: Painter,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(percent = 12))
            .clickable {
                // onResume
            }
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = stringResource(R.string.audiobook_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0f to Black.copy(0.7f),
                            0.3f to Transparent,
                            0.8f to Black.copy(0.7f),
                            1f to Black.copy(0.7f)
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = author,
                    fontSize = 20.sp,
                    fontFamily = GothamProRegular,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = true
                        ),
                        lineHeightStyle = LineHeightStyle(
                            trim = LineHeightStyle.Trim.Both,
                            alignment = LineHeightStyle.Alignment.Center,
                        )
                    ),
                    color = White
                )
                Spacer(Modifier.fillMaxHeight(0.02f))
                Text(
                    text = buildAnnotatedString {
                        append("$hourLeft" + "h $minuteLeft" + "m")
                        withStyle(
                            SpanStyle(
                                color = White.copy(0.7f)
                            )
                        ) {
                            append(" left")
                        }
                    },
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
                    color = White
                )
            }
            Text(
                text = title,
                fontSize = 30.sp,
                fontFamily = GothamProRegular,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    lineHeight = 1.2.em
                ),
                color = White
            )
        }
    }
}

@Preview
@Composable
private fun RecentlyPlayedCardPreview() {
    AudioBookComposeTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            RecentlyPlayedCard(
                author = "Yuval Noah Harari",
                hourLeft = 8,
                minuteLeft = 24,
                backgroundImage = painterResource(R.drawable.sapiens_yuval_noah_harari),
                title = "Sapiens. A Brief History of Humankind",
            )
        }
    }
}