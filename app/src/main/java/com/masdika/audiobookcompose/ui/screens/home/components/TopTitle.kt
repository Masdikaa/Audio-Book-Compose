package com.masdika.audiobookcompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.ui.icons.SearchIcon
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProBold

@Composable
fun TopTitle(
    onSearchIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val topTitleTextSize: TextUnit = 24.sp
    val iconSize: Dp = with(LocalDensity.current) { topTitleTextSize.toDp() }
    val backgroundColor = MaterialTheme.colorScheme.background
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Text(
            text = "Read Me",
            fontSize = topTitleTextSize,
            fontFamily = GothamProBold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = true
                ), lineHeightStyle = LineHeightStyle(
                    trim = LineHeightStyle.Trim.Both,
                    alignment = LineHeightStyle.Alignment.Center,
                )
            ),
            color = onBackgroundColor
        )
        Icon(
            imageVector = SearchIcon,
            contentDescription = null,
            tint = onBackgroundColor,
            modifier = modifier
                .size(iconSize + 5.dp)
                .wrapContentHeight()
                .clickable(
                    onClick = {
                        onSearchIconClicked()
                    }
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopTitlePreview() {
    AudioBookComposeTheme {
        TopTitle({})
    }
}