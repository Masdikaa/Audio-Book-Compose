package com.masdika.audiobookcompose.ui.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.data.model.AudioBook
import com.masdika.audiobookcompose.data.model.Genre
import com.masdika.audiobookcompose.data.model.RecentlyPlayedUi
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.data.model.genreList
import com.masdika.audiobookcompose.ui.screen.home.component.AudioBookCard
import com.masdika.audiobookcompose.ui.screen.home.component.GenreList
import com.masdika.audiobookcompose.ui.screen.home.component.RecentlyPlayedCard
import com.masdika.audiobookcompose.ui.screen.home.component.TopTitle
import com.masdika.audiobookcompose.ui.screen.home.component.bottombar.BottomNavigation
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.viewmodel.home.HomeUIState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    uiState: HomeUIState,
    recentlyPlayed: RecentlyPlayedUi?,
    onAudioBookClicked: (String) -> Unit,
    onSearchIconClicked: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToMenu: () -> Unit,
    onNavigateToProfile: () -> Unit,
    modifier: Modifier = Modifier

) {
    val backgroundColor = MaterialTheme.colorScheme.background
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            if (uiState is HomeUIState.Success) {
                BottomNavigation(
                    selectedIndex = selectedItemIndex,
                    onSelect = { index ->
                        selectedItemIndex = index
                        when (index) {
                            0 -> onNavigateToHome()
                            1 -> onNavigateToMenu()
                            2 -> onNavigateToProfile()
                        }
                    },
                    backgroundColor = backgroundColor
                )
            }
        },
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) { innerPadding ->
        when (uiState) {
            is HomeUIState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    CircularProgressIndicator(Modifier.padding(innerPadding))
                }
            }

            is HomeUIState.Success -> {
                var selectedIndex by remember { mutableIntStateOf(0) }
                val audioBooks = uiState.audioBooks
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

                HomeScreenContent(
                    audioBooks = filteredAudioBooks,
                    genres = genreList,
                    selectedIndex = selectedIndex,
                    onGenreSelected = { newIndex -> selectedIndex = newIndex },
                    onSearchIconClicked = onSearchIconClicked,
                    recentlyPlayed = recentlyPlayed,
                    onAudioBookClicked = onAudioBookClicked,
                    modifier = Modifier.padding(innerPadding),
                    backgroundColor = backgroundColor
                )
            }

            is HomeUIState.Error -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Text("Unable to load data")
                }
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    audioBooks: List<AudioBook>,
    genres: List<Genre>,
    selectedIndex: Int,
    onGenreSelected: (Int) -> Unit,
    onSearchIconClicked: () -> Unit,
    recentlyPlayed: RecentlyPlayedUi?,
    onAudioBookClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                TopTitle(
                    onSearchIconClicked = onSearchIconClicked,
                    modifier = Modifier.height(60.dp)
                )
                if (recentlyPlayed != null) {
                    val hours = recentlyPlayed.remainingDuration / 3600
                    val minutes = (recentlyPlayed.remainingDuration % 3600) / 60
                    RecentlyPlayedCard(
                        author = recentlyPlayed.author,
                        hourLeft = hours.toInt(),
                        minuteLeft = minutes.toInt(),
                        backgroundImage = painterResource(id = recentlyPlayed.imageId),
                        title = recentlyPlayed.title,
                    )
                } else {
                    Text("No recently played books yet. Click a book to start!")
                }

                Spacer(Modifier.height(10.dp))
            }
        }

        stickyHeader {
            Column(modifier = Modifier.background(backgroundColor)) {
                GenreList(
                    genres = genres,
                    selectedIndex = selectedIndex,
                    onGenreSelected = { newIndex ->
                        if (selectedIndex != newIndex) {
                            onGenreSelected(newIndex)
                            coroutineScope.launch {
                                if (listState.firstVisibleItemIndex >= 1) {
                                    listState.scrollToItem(1)
                                }
                            }
                        }
                    }
                )
                Spacer(Modifier.height(10.dp))
            }
        }

        items(
            items = audioBooks,
            key = { it.id }
        ) { item ->
            AudioBookCard(
                id = item.id,
                author = item.author,
                title = item.title,
                synopsys = item.synopsys,
                rating = item.rating,
                image = item.imageID,
                onAudioBookClicked = { onAudioBookClicked(item.id) }
            )
            Spacer(Modifier.height(20.dp))
        }

        if (audioBooks.size < 3) {
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillParentMaxHeight(1f)
                        .background(backgroundColor)
                )
            }
        }
    }
}

@Preview(
    name = "Home Screen Success Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Success Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun HomeScreenSuccessPreview() {
    AudioBookComposeTheme {
        val recentlyPlayedSample = RecentlyPlayedUi(
            title = "Sapiens: A Brief History of Humankind",
            author = "Yuval Noah Harari",
            imageId = R.drawable.sapiens_yuval_noah_harari,
            remainingDuration = 18000L - 1234L
        )
        HomeScreen(
            uiState = HomeUIState.Success(audioBookList),
            recentlyPlayed = recentlyPlayedSample,
            onAudioBookClicked = {},
            onSearchIconClicked = {},
            onNavigateToHome = {},
            onNavigateToMenu = {},
            onNavigateToProfile = {},
        )

    }
}

@Preview(
    name = "Home Screen Loading Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Loading Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun HomeScreenLoadingPreview() {
    AudioBookComposeTheme {
        HomeScreen(
            uiState = HomeUIState.Loading,
            recentlyPlayed = null,
            onAudioBookClicked = {},
            onSearchIconClicked = {},
            onNavigateToHome = {},
            onNavigateToMenu = {},
            onNavigateToProfile = {},
        )
    }
}

@Preview(
    name = "Home Screen Error Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Error Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun HomeScreenErrorPreview() {
    AudioBookComposeTheme {
        HomeScreen(
            uiState = HomeUIState.Error("Unable to load data"),
            recentlyPlayed = null,
            onAudioBookClicked = {},
            onSearchIconClicked = {},
            onNavigateToHome = {},
            onNavigateToMenu = {},
            onNavigateToProfile = {},
        )
    }
}

