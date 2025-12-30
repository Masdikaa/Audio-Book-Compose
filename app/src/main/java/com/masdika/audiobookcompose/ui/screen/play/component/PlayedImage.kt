package com.masdika.audiobookcompose.ui.screen.play.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.JeansBlue

@Composable
fun PlayedImage(
    modifier: Modifier = Modifier,
    imageId: Int = R.drawable.ic_launcher_background
) {
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight(0.45f)
            .clip(RoundedCornerShape(percent = 5))
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = stringResource(R.string.audiobook_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
)
@Composable
private fun PlayedImagePreview() {
    AudioBookComposeTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(JeansBlue)
                .padding(20.dp)
        ) {
            PlayedImage()
        }
    }
}