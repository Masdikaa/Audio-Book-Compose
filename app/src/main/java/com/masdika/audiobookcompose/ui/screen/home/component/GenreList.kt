package com.masdika.audiobookcompose.ui.screen.home.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.data.model.Genre
import com.masdika.audiobookcompose.data.model.genreList
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProRegular
import com.masdika.audiobookcompose.ui.theme.Night
import com.masdika.audiobookcompose.ui.theme.Transparent
import com.masdika.audiobookcompose.ui.theme.White

@Composable
fun GenreList(
    genres: List<Genre>,
    selectedIndex: Int,
    onGenreSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground

    LazyRow(
        contentPadding = PaddingValues(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(genres.size + 1) { index ->

            val genreName = if (index == 0) "All" else genres[index - 1].name
            val isSelected = selectedIndex == index
            val backgroundColor by animateColorAsState(
                targetValue = if (isSystemInDarkTheme()) {
                    if (isSelected) onBackgroundColor else Transparent
                } else {
                    if (isSelected) Night else Transparent
                },
                label = "backgroundAnimation"
            )
            val textColor by animateColorAsState(
                targetValue = if (isSystemInDarkTheme()) {
                    if (isSelected) Night else onBackgroundColor
                } else {
                    if (isSelected) White else onBackgroundColor
                },
                label = "textAnimation"
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(percent = 40))
                    .background(backgroundColor)
                    .clickable {
                        onGenreSelected(index)
                    }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = genreName,
                    fontSize = 18.sp,
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
                    color = textColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GenreListPreview() {
    AudioBookComposeTheme {
        GenreList(
            genres = genreList,
            selectedIndex = 0,
            onGenreSelected = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}