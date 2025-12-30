package com.masdika.audiobookcompose.ui.screen.home.component.bottombar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.icon.HomeIcon
import com.masdika.audiobookcompose.ui.icon.MenuIcon
import com.masdika.audiobookcompose.ui.theme.Night

@Composable
fun BottomNavigation(
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    backgroundColor: Color
) {
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(
            onClick = { onSelect(0) }
        ) {
            Icon(
                imageVector = HomeIcon,
                contentDescription = stringResource(R.string.home_icon),
                tint = backgroundColorAnimation(selectedIndex, 0),
                modifier = Modifier.size(24.dp)
            )
        }
        BottomBarItem(
            onClick = { onSelect(1) }
        ) {
            Icon(
                imageVector = MenuIcon,
                contentDescription = stringResource(R.string.menu_icon),
                tint = backgroundColorAnimation(selectedIndex, 1),
                modifier = Modifier.size(24.dp)
            )
        }
        BottomBarItem(
            onClick = { onSelect(2) }
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(
                        backgroundColorAnimation(selectedIndex, 2)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = stringResource(R.string.profile_icon),
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun backgroundColorAnimation(selectedIndex: Int, index: Int): Color {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSystemInDarkTheme()) {
            if (selectedIndex == index) Color.LightGray else Color.DarkGray
        } else {
            if (selectedIndex == index) Night else Color.LightGray
        },
        animationSpec = tween(
            durationMillis = 120,
            easing = LinearOutSlowInEasing
        ),
        label = "selectedColorAnimation"
    )
    return backgroundColor
}