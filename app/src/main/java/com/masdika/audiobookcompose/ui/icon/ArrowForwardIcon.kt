package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArrowForwardIcon: ImageVector
    get() {
        if (_ArrowForwardIcon != null) {
            return _ArrowForwardIcon!!
        }
        _ArrowForwardIcon = ImageVector.Builder(
            name = "ArrowForwardIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(13f, 22f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                arcToRelative(9f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = true, 9f, -9f)
                arcToRelative(8.9f, 8.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.166f, 4.42f)
                lineToRelative(-1.127f, -1.127f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 17f, 16f)
                lineToRelative(0f, 4f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                lineTo(22f, 21f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.707f, -1.707f)
                lineTo(21.3f, 17.882f)
                arcTo(10.9f, 10.9f, 45f, isMoreThanHalf = false, isPositiveArc = false, 23f, 12f)
                arcToRelative(11f, 11f, 65.095f, isMoreThanHalf = true, isPositiveArc = false, -11f, 11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                close()
            }
        }.build()

        return _ArrowForwardIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowForwardIcon: ImageVector? = null
