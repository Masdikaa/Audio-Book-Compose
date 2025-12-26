package com.masdika.audiobookcompose.ui.screen.home.component.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProItalic
import com.masdika.audiobookcompose.ui.theme.GothamProRegular

@Composable
fun SearchItem(
    bookId: String,
    author: String,
    title: String,
    onSearchItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable {
                onSearchItemClicked(bookId)
            }
    ) {
        Text(
            text = buildAnnotatedString {
                append("$title - ")
                withStyle(
                    SpanStyle(
                        fontFamily = GothamProItalic
                    )
                ) {
                    append(author)
                }
            },
            textAlign = TextAlign.Start,
            fontFamily = GothamProRegular,
            fontSize = 16.sp,
            maxLines = 2,
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
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun SearchItemPreview() {
    AudioBookComposeTheme {
        SearchItem(
            bookId = "0",
            author = "Author Name",
            title = "Title",
            onSearchItemClicked = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}