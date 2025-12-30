package com.masdika.audiobookcompose.ui.screen.home.component.bottombar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.ui.icon.HomeIcon
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme

@Composable
fun BottomBarItem(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
private fun BottomBarItemPreview() {
    AudioBookComposeTheme {
        BottomBarItem(
            onClick = {},
        ) {
            Icon(
                imageVector = HomeIcon,
                contentDescription = "Home Icon",
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}