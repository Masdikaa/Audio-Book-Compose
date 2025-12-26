package com.masdika.audiobookcompose.ui.screen.home.component

import StarIcon
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.audiobookcompose.R
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme
import com.masdika.audiobookcompose.ui.theme.GothamProMedium
import com.masdika.audiobookcompose.ui.theme.GothamProRegular

@Composable
fun AudioBookCard(
    id: String,
    author: String,
    title: String,
    synopsys: String,
    rating: Double,
    modifier: Modifier = Modifier,
    onAudioBookClicked: (String) -> Unit,
    image: Int = R.drawable.ic_launcher_background
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .border(
                shape = RoundedCornerShape(10),
                color = if (isSystemInDarkTheme()) Color.Gray.copy(0.4f) else Color.LightGray,
                width = 1.dp
            )
            .clip(RoundedCornerShape(10))
            .clickable {
                onAudioBookClicked(id)
            }
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(160.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(20))
        )
        Spacer(Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = author,
                    fontSize = 18.sp,
                    fontFamily = GothamProRegular,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
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
                    color = if (isSystemInDarkTheme()) Color.LightGray else Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(5.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(65.dp)
                        .clip(RoundedCornerShape(40))
                        .background(MaterialTheme.colorScheme.onBackground)
                        .padding(horizontal = 12.dp, vertical = 5.dp)
                ) {
                    Icon(
                        imageVector = StarIcon,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(
                            with(LocalDensity.current) { 14.sp.toDp() }
                        )
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = rating.toString(),
                        fontSize = 14.sp,
                        fontFamily = GothamProRegular,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ),
                            lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Center,
                            )
                        ),
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            Spacer(Modifier.height(35.dp))
            Text(
                text = title,
                fontSize = 20.sp,
                fontFamily = GothamProMedium,
                maxLines = 1,
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
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = synopsys,
                fontSize = 16.sp,
                fontFamily = GothamProRegular,
                maxLines = 4,
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
                color = if (isSystemInDarkTheme()) Color.LightGray else Color.Gray,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = false,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun AudioBookCardPreview() {
    AudioBookComposeTheme {
        AudioBookCard(
            id = "1",
            author = "Elizabeth Gilbert",
            title = "Audio Book Title",
            synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
            rating = 4.5,
            onAudioBookClicked = {},
        )
    }
}