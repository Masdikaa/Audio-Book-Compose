package com.masdika.audiobookcompose.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SearchIcon: ImageVector
    get() {
        if (_SearchIcon != null) {
            return _SearchIcon!!
        }
        _SearchIcon = ImageVector.Builder(
            name = "SearchIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(505.74f, 476.33f)
                lineToRelative(-88f, -86f)
                lineToRelative(-2.06f, -3.13f)
                arcToRelative(
                    20.72f,
                    20.72f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -29.1f,
                    0f
                )
                curveToRelative(-74.79f, 68.61f, -190f, 72.33f, -269.28f, 8.71f)
                reflectiveCurveTo(19.35f, 221f, 73.62f, 135.94f)
                reflectiveCurveToRelative(164.67f, -117.59f, 258f, -76f)
                reflectiveCurveTo(472.16f, 204.39f, 442f, 300.23f)
                arcToRelative(
                    19.93f,
                    19.93f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    4.69f,
                    19.77f
                )
                arcToRelative(
                    21f,
                    21f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    19.82f,
                    5.94f
                )
                arcToRelative(
                    20.57f,
                    20.57f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    15.17f,
                    -13.82f
                )
                curveToRelative(36f, -113.73f, -18.38f, -236.13f, -128f, -288f)
                reflectiveCurveTo(112.15f, 6.42f, 43.24f, 104.59f)
                reflectiveCurveToRelative(-54.12f, 230.82f, 34.81f, 312.17f)
                reflectiveCurveTo(303.35f, 503.7f, 399f, 430f)
                lineToRelative(77.92f, 76.18f)
                arcToRelative(
                    21f,
                    21f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    29.1f,
                    0f
                )
                arcToRelative(
                    20.07f,
                    20.07f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -28.68f
                )
                close()
            }
        }.build()

        return _SearchIcon!!
    }

@Suppress("ObjectPropertyName")
private var _SearchIcon: ImageVector? = null
