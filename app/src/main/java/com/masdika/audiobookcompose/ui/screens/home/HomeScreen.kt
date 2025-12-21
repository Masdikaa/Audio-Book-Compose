package com.masdika.audiobookcompose.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.data.model.AudioBook
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.data.model.genreList
import com.masdika.audiobookcompose.ui.screens.home.components.AudioBookCard
import com.masdika.audiobookcompose.ui.screens.home.components.GenreList
import com.masdika.audiobookcompose.ui.screens.home.components.RecentlyPlayedCard
import com.masdika.audiobookcompose.ui.screens.home.components.TopTitle
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme

@Composable
fun HomeScreen(
    audioBooks: List<AudioBook>,
    onSearchIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = MaterialTheme.colorScheme.background
//    val onBackgroundColor = MaterialTheme.colorScheme.onBackground
    var selectedIndex by remember { mutableIntStateOf(0) }

    val filteredAudioBooks by remember(selectedIndex, audioBooks) {
        mutableStateOf(
            if (selectedIndex == 0) {
                audioBooks
            } else {
                val selectedGenreName = genreList[selectedIndex - 1].name
                audioBooks.filter { audioBook ->
                    audioBook.genre.any { it.name == selectedGenreName }
                }
            }
        )
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
        // TODO() Implement BottomBar
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            TopTitle(
                onSearchIconClicked = onSearchIconClicked,
                modifier = Modifier.fillMaxHeight(0.1f)
            )
            RecentlyPlayedCard(
                author = "Yuval Noah Harari",
                hourLeft = 8,
                minuteLeft = 24,
                backgroundImage = painterResource(R.drawable.sample),
                title = "Sapiens. A Brief History of Humankind",
            )
            Spacer(Modifier.fillMaxHeight(0.02f))
            GenreList(
                genres = genreList,
                selectedIndex = selectedIndex,
                onGenreSelected = { newIndex ->
                    selectedIndex = newIndex
                }
            )
            Spacer(Modifier.fillMaxHeight(0.02f))
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    filteredAudioBooks.forEach { item ->
                        AudioBookCard(
                            author = item.author,
                            title = item.title,
                            synopsys = item.synopsys,
                            rating = item.rating,
                            image = item.imageID
                        )
                        Spacer(Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Preview(
    name = "Home Screen Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun HomeScreenPreview() {
    AudioBookComposeTheme {
        HomeScreen(
            audioBooks = audioBookList,
            onSearchIconClicked = {}
        )
    }
}

