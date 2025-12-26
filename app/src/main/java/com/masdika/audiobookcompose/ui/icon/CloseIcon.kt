import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val CloseIcon: ImageVector
    get() {
        if (_CloseIcon != null) {
            return _CloseIcon!!
        }
        _CloseIcon = ImageVector.Builder(
            name = "CloseIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(24f, 0f)
                arcToRelative(24f, 24f, 0f, isMoreThanHalf = true, isPositiveArc = false, 24f, 24f)
                arcTo(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = false, 24f, 0f)
                close()
                moveTo(34.6f, 30.66f)
                arcToRelative(
                    2.79f,
                    2.79f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -3.94f,
                    3.94f
                )
                lineTo(24f, 27.94f)
                lineToRelative(-6.66f, 6.66f)
                arcToRelative(
                    2.79f,
                    2.79f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -3.94f,
                    -3.94f
                )
                lineTo(20.06f, 24f)
                lineToRelative(-6.66f, -6.66f)
                arcToRelative(
                    2.79f,
                    2.79f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    3.94f,
                    -3.94f
                )
                lineTo(24f, 20.06f)
                lineToRelative(6.66f, -6.66f)
                arcToRelative(
                    2.79f,
                    2.79f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    3.94f,
                    3.94f
                )
                lineTo(27.94f, 24f)
                close()
            }
        }.build()

        return _CloseIcon!!
    }

@Suppress("ObjectPropertyName")
private var _CloseIcon: ImageVector? = null
