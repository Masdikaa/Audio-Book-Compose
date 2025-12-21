import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val StarIcon: ImageVector
    get() {
        if (_StarIcon != null) {
            return _StarIcon!!
        }
        _StarIcon = ImageVector.Builder(
            name = "StarIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 511.99f,
            viewportHeight = 511f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFC107))) {
                moveTo(510.65f, 185.9f)
                arcToRelative(27.16f, 27.16f, 0f, isMoreThanHalf = false, isPositiveArc = false, -23.42f, -18.71f)
                lineToRelative(-147.77f, -13.42f)
                lineToRelative(-58.43f, -136.77f)
                curveTo(276.71f, 6.98f, 266.9f, 0.49f, 256f, 0.49f)
                reflectiveCurveToRelative(-20.72f, 6.49f, -25.02f, 16.53f)
                lineToRelative(-58.43f, 136.75f)
                lineToRelative(-147.8f, 13.42f)
                arcTo(27.21f, 27.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.34f, 185.9f)
                curveToRelative(-3.37f, 10.37f, -0.26f, 21.74f, 7.96f, 28.91f)
                lineToRelative(111.7f, 97.96f)
                lineToRelative(-32.94f, 145.09f)
                curveToRelative(-2.41f, 10.67f, 1.73f, 21.7f, 10.58f, 28.09f)
                curveToRelative(4.76f, 3.44f, 10.32f, 5.19f, 15.94f, 5.19f)
                curveToRelative(4.84f, 0f, 9.64f, -1.3f, 13.95f, -3.88f)
                lineToRelative(127.47f, -76.18f)
                lineToRelative(127.42f, 76.18f)
                curveToRelative(9.32f, 5.61f, 21.08f, 5.1f, 29.91f, -1.3f)
                arcToRelative(27.22f, 27.22f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10.58f, -28.09f)
                lineToRelative(-32.94f, -145.09f)
                lineToRelative(111.7f, -97.94f)
                arcToRelative(27.22f, 27.22f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.98f, -28.93f)
                close()
                moveTo(510.65f, 185.9f)
            }
        }.build()

        return _StarIcon!!
    }

@Suppress("ObjectPropertyName")
private var _StarIcon: ImageVector? = null