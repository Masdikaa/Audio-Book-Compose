package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val BookmarkIcon: ImageVector
    get() {
        if (_BookmarkIcon != null) {
            return _BookmarkIcon!!
        }
        _BookmarkIcon = ImageVector.Builder(
            name = "BookmarkIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(18.248f, 22.598f)
                arcToRelative(
                    2.742f,
                    2.742f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -1.456f,
                    -0.423f
                )
                lineTo(12.53f, 19.51f)
                arcToRelative(
                    1.006f,
                    1.006f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -1.06f,
                    0f
                )
                lineToRelative(-4.262f, 2.664f)
                arcTo(2.75f, 2.75f, 0f, isMoreThanHalf = false, isPositiveArc = true, 3f, 19.843f)
                verticalLineTo(4.5f)
                arcTo(3.504f, 3.504f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.5f, 1f)
                horizontalLineToRelative(11f)
                arcTo(3.504f, 3.504f, 0f, isMoreThanHalf = false, isPositiveArc = true, 21f, 4.5f)
                verticalLineToRelative(15.343f)
                arcToRelative(
                    2.715f,
                    2.715f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -1.417f,
                    2.405f
                )
                arcToRelative(
                    2.746f,
                    2.746f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -1.335f,
                    0.35f
                )
                close()
                moveTo(12f, 17.362f)
                arcToRelative(
                    2.995f,
                    2.995f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    1.59f,
                    0.453f
                )
                lineToRelative(4.263f, 2.664f)
                arcTo(0.75f, 0.75f, 0f, isMoreThanHalf = false, isPositiveArc = false, 19f, 19.843f)
                verticalLineTo(4.5f)
                arcTo(1.502f, 1.502f, 0f, isMoreThanHalf = false, isPositiveArc = false, 17.5f, 3f)
                horizontalLineToRelative(-11f)
                arcTo(1.502f, 1.502f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5f, 4.5f)
                verticalLineToRelative(15.343f)
                arcToRelative(
                    0.75f,
                    0.75f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    1.148f,
                    0.636f
                )
                lineToRelative(4.262f, -2.665f)
                arcToRelative(
                    3f,
                    3f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    1.59f,
                    -0.452f
                )
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(16f, 8f)
                horizontalLineTo(8f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -2f)
                horizontalLineToRelative(8f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 2f)
                close()
            }
        }.build()

        return _BookmarkIcon!!
    }

@Suppress("ObjectPropertyName")
private var _BookmarkIcon: ImageVector? = null