package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArrowBackwardIcon: ImageVector
    get() {
        if (_ArrowBackwardIcon != null) {
            return _ArrowBackwardIcon!!
        }
        _ArrowBackwardIcon = ImageVector.Builder(
            name = "ArrowBackwardIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(11f, 22f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, -1f)
                arcToRelative(9f, 9f, 127.89f, isMoreThanHalf = true, isPositiveArc = false, -9f, -9f)
                arcToRelative(8.9f, 8.9f, 45f, isMoreThanHalf = false, isPositiveArc = false, 1.166f, 4.42f)
                lineToRelative(1.127f, -1.127f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7f, 16f)
                lineToRelative(-0f, 4f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, 1f)
                lineTo(2f, 21f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.707f, -1.707f)
                lineTo(2.7f, 17.882f)
                arcTo(10.9f, 10.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, 12f)
                arcToRelative(11f, 11f, 65.095f, isMoreThanHalf = true, isPositiveArc = true, 11f, 11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, -1f)
                close()
            }
        }.build()

        return _ArrowBackwardIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowBackwardIcon: ImageVector? = null
