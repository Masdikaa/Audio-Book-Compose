package com.masdika.audiobookcompose.ui.screen.home

import HomeIcon
import MenuIcon
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.data.model.audioBookList
import com.masdika.audiobookcompose.data.model.genreList
import com.masdika.audiobookcompose.ui.screen.home.component.AudioBookCard
import com.masdika.audiobookcompose.ui.screen.home.component.GenreList
import com.masdika.audiobookcompose.ui.screen.home.component.RecentlyPlayedCard
import com.masdika.audiobookcompose.ui.screen.home.component.TopTitle
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.utils.NoRippleIndication
import com.masdika.audiobookcompose.viewmodel.home.HomeUIState

@Composable
fun HomeScreen(
    uiState: HomeUIState,
    onSearchIconClicked: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToMenu: () -> Unit,
    onNavigateToProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = MaterialTheme.colorScheme.background
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            CompositionLocalProvider(
                LocalIndication provides NoRippleIndication
            ) {
                NavigationBar(
                    containerColor = backgroundColor,
                    modifier = Modifier.height(70.dp)
                ) {
                    NavigationBarItem(
                        selected = selectedItemIndex == 0,
                        onClick = {
                            selectedItemIndex = 0
                            onNavigateToHome
                        },
                        icon = {
                            Icon(
                                imageVector = HomeIcon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                            unselectedIconColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 1,
                        onClick = {
                            selectedItemIndex = 1
                            onNavigateToMenu
                        },
                        icon = {
                            Icon(
                                imageVector = MenuIcon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                            unselectedIconColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 2,
                        onClick = {
                            selectedItemIndex = 2
                            onNavigateToProfile
                        },
                        icon = {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(
                                        color =
                                            if (isSystemInDarkTheme()) {
                                                if (selectedItemIndex == 2) Color.LightGray else Color.DarkGray
                                            } else {
                                                if (selectedItemIndex == 2) Color.DarkGray else Color.LightGray
                                            }
                                    )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_launcher_background),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .clip(CircleShape)
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        },
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
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
            uiState = HomeUIState.Success(audioBookList),
            onSearchIconClicked = {},
            onNavigateToHome = {},
            onNavigateToMenu = {},
            onNavigateToProfile = {},
        )
    }
}

