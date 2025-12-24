import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val MenuIcon: ImageVector
    get() {
        if (_MenuIcon != null) {
            return _MenuIcon!!
        }
        _MenuIcon = ImageVector.Builder(
            name = "MenuIcon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 297f,
            viewportHeight = 297f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(107.88f, 0f)
                horizontalLineToRelative(-85.27f)
                curveTo(10.14f, 0f, 0f, 10.14f, 0f, 22.61f)
                verticalLineToRelative(85.27f)
                curveToRelative(0f, 12.47f, 10.14f, 22.61f, 22.61f, 22.61f)
                horizontalLineToRelative(85.27f)
                curveToRelative(12.47f, 0f, 22.61f, -10.14f, 22.61f, -22.61f)
                verticalLineToRelative(-85.27f)
                curveTo(130.49f, 10.14f, 120.35f, 0f, 107.88f, 0f)
                close()
                moveTo(274.39f, 0f)
                horizontalLineToRelative(-85.27f)
                curveToRelative(-12.47f, 0f, -22.61f, 10.14f, -22.61f, 22.61f)
                verticalLineToRelative(85.27f)
                curveToRelative(0f, 12.47f, 10.14f, 22.61f, 22.61f, 22.61f)
                horizontalLineToRelative(85.27f)
                curveToRelative(12.47f, 0f, 22.61f, -10.14f, 22.61f, -22.61f)
                verticalLineToRelative(-85.27f)
                curveTo(297f, 10.14f, 286.86f, 0f, 274.39f, 0f)
                close()
                moveTo(107.88f, 166.51f)
                horizontalLineToRelative(-85.27f)
                curveToRelative(-12.47f, 0f, -22.61f, 10.14f, -22.61f, 22.61f)
                verticalLineToRelative(85.27f)
                curveTo(0f, 286.86f, 10.14f, 297f, 22.61f, 297f)
                horizontalLineToRelative(85.27f)
                curveToRelative(12.47f, 0f, 22.61f, -10.14f, 22.61f, -22.61f)
                verticalLineToRelative(-85.27f)
                curveToRelative(-0f, -12.47f, -10.14f, -22.61f, -22.61f, -22.61f)
                close()
                moveTo(274.39f, 166.51f)
                horizontalLineToRelative(-85.27f)
                curveToRelative(-12.47f, 0f, -22.61f, 10.14f, -22.61f, 22.61f)
                verticalLineToRelative(85.27f)
                curveToRelative(0f, 12.47f, 10.14f, 22.61f, 22.61f, 22.61f)
                horizontalLineToRelative(85.27f)
                curveTo(286.86f, 297f, 297f, 286.86f, 297f, 274.39f)
                verticalLineToRelative(-85.27f)
                curveToRelative(0f, -12.47f, -10.14f, -22.61f, -22.61f, -22.61f)
                close()
            }
        }.build()

        return _MenuIcon!!
    }

@Suppress("ObjectPropertyName")
private var _MenuIcon: ImageVector? = null
