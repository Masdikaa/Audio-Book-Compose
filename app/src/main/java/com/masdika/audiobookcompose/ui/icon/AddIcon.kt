package com.masdika.audiobookcompose.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AddIcon: ImageVector
    get() {
        if (_AddIcon != null) {
            return _AddIcon!!
        }
        _AddIcon = ImageVector.Builder(
            name = "AddIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(18f, 2f)
                curveToRelative(2.206f, 0f, 4f, 1.794f, 4f, 4f)
                verticalLineToRelative(12f)
                curveToRelative(0f, 2.206f, -1.794f, 4f, -4f, 4f)
                lineTo(6f, 22f)
                curveToRelative(-2.206f, 0f, -4f, -1.794f, -4f, -4f)
                lineTo(2f, 6f)
                curveToRelative(0f, -2.206f, 1.794f, -4f, 4f, -4f)
                close()
                moveTo(18f, 0f)
                lineTo(6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -6f, 6f)
                verticalLineToRelative(12f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6f, 6f)
                horizontalLineToRelative(12f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6f, -6f)
                lineTo(24f, 6f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -6f, -6f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 18f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, -1f)
                verticalLineTo(7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 0f)
                verticalLineToRelative(10f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, 1f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(6f, 12f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, -1f)
                horizontalLineToRelative(10f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 2f)
                horizontalLineTo(7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, -1f)
                close()
            }
        }.build()

        return _AddIcon!!
    }

@Suppress("ObjectPropertyName")
private var _AddIcon: ImageVector? = null