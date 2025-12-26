package com.masdika.audiobookcompose.ui.screen.home.component.search

import BackIcon
import CloseIcon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.data.model.AudioBook
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme

@Composable
fun SearchUI(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    searchResults: List<AudioBook>,
    onSearchItemClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }

    SideEffect {
        focusRequester.requestFocus()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = onCloseClicked,
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = BackIcon,
                    contentDescription = "Back",
                )
            }
            Spacer(Modifier.width(10.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                label = { Text("Search for audiobooks...") },
                singleLine = true,
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = { onSearchQueryChanged("") },
                            modifier = Modifier.size(18.dp)
                        ) {
                            Icon(imageVector = CloseIcon, contentDescription = null)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
            )
        }
        Spacer(Modifier.height(16.dp))
        if (searchResults.isEmpty() && searchQuery.isNotBlank()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("No results found for \"$searchQuery\"")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(
                    items = searchResults,
                    key = { it.id }
                ) {
                    SearchItem(
                        bookId = it.id,
                        author = it.author,
                        title = it.title,
                        onSearchItemClicked = onSearchItemClicked
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchUIPreview() {
    AudioBookComposeTheme {
        SearchUI(
            searchQuery = "Sapiens",
            onSearchQueryChanged = {},
            searchResults = audioBookList,
            onSearchItemClicked = {},
            onCloseClicked = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}