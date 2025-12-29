package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SpeakerIcon: ImageVector
    get() {
        if (_SpeakerIcon != null) {
            return _SpeakerIcon!!
        }
        _SpeakerIcon = ImageVector.Builder(
            name = "SpeakerIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(17.5f, 4f)
                arcToRelative(
                    2.53f,
                    2.53f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -1.5f,
                    0.5f
                )
                lineTo(8.67f, 10f)
                lineTo(5f, 10f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3f, 3f)
                verticalLineToRelative(6f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3f, 3f)
                horizontalLineToRelative(3.67f)
                lineTo(16f, 27.5f)
                arcToRelative(
                    2.53f,
                    2.53f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    1.5f,
                    0.5f
                )
                arcToRelative(
                    2.5f,
                    2.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    2.5f,
                    -2.5f
                )
                verticalLineToRelative(-19f)
                arcTo(2.5f, 2.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 17.5f, 4f)
                close()
                moveTo(18f, 25.5f)
                arcToRelative(
                    0.52f,
                    0.52f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -0.8f,
                    0.4f
                )
                lineToRelative(-7.6f, -5.7f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 9f, 20f)
                lineTo(5f, 20f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, -1f)
                verticalLineToRelative(-6f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, -1f)
                horizontalLineToRelative(4f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.6f,
                    -0.2f
                )
                lineToRelative(7.6f, -5.7f)
                arcToRelative(
                    0.52f,
                    0.52f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    0.8f,
                    0.4f
                )
                close()
                moveTo(26.78f, 8.22f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.42f,
                    1.42f
                )
                arcToRelative(9f, 9f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 12.72f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 1.42f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.42f, 0f)
                arcToRelative(
                    11f,
                    11f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -15.56f
                )
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(23.94f, 11.05f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.4f,
                    1.42f
                )
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 7.06f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.7f,
                    1.71f
                )
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.7f,
                    -0.29f
                )
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -9.9f)
                close()
            }
        }.build()

        return _SpeakerIcon!!
    }

@Suppress("ObjectPropertyName")
private var _SpeakerIcon: ImageVector? = null