package com.masdika.audiobookcompose.ui.screen.play.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProMedium
import com.masdika.audiobookcompose.ui.theme.GothamProRegular
import com.masdika.audiobookcompose.ui.theme.JeansBlue
import com.masdika.audiobookcompose.ui.theme.Night
import com.masdika.audiobookcompose.ui.theme.SmokeWhite

@Composable
fun AudioBookTitle(
    title: String,
    author: String,
    modifier: Modifier = Modifier
) {
    val onBackground = if (isSystemInDarkTheme()) SmokeWhite else Night

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
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
        Spacer(Modifier.height(5.dp))
        Text(
            text = author,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = GothamProRegular,
            fontWeight = FontWeight.Normal,
            color = if (isSystemInDarkTheme()) Color.Gray.copy(0.6f) else Color.DarkGray.copy(0.7f)
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun AudioBookTitlePreview() {
    AudioBookComposeTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(JeansBlue)
        ) {
            AudioBookTitle(
                title = "AudioBook Title",
                author = "AudioBook Author"
            )
        }
    }
}