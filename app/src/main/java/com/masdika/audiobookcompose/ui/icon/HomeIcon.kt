package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HomeIcon: ImageVector
    get() {
        if (_HomeIcon != null) {
            return _HomeIcon!!
        }
        _HomeIcon = ImageVector.Builder(
            name = "HomeIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(28.91f, 9.07f)
                lineToRelative(-10f, -7.14f)
                arcToRelative(5.018f, 5.018f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.82f, 0f)
                lineToRelative(-10f, 7.14f)
                arcTo(5.018f, 5.018f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 13.14f)
                verticalLineTo(26f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5f, 5f)
                horizontalLineToRelative(4f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2f, -2f)
                verticalLineToRelative(-8f)
                curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                horizontalLineToRelative(4f)
                curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                verticalLineToRelative(8f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2f, 2f)
                horizontalLineToRelative(4f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5f, -5f)
                verticalLineTo(13.14f)
                curveToRelative(0f, -1.61f, -0.78f, -3.13f, -2.09f, -4.07f)
                close()
            }
        }.build()

        return _HomeIcon!!
    }

@Suppress("ObjectPropertyName")
private var _HomeIcon: ImageVector? = null