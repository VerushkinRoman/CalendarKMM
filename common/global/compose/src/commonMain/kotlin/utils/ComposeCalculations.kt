package utils

import DeviceType
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import com.moriatsushi.insetsx.navigationBars
import com.moriatsushi.insetsx.safeArea

@Composable
fun navBarBottomIntPadding(): Int = WindowInsets.navigationBars.getBottom(LocalDensity.current)

@Composable
fun getSystemPaddings(): PaddingValues = WindowInsets.safeArea.asPaddingValues()

val DeviceTypeProvider = staticCompositionLocalOf<DeviceType> { error("no default implementation") }

data class ScreenSizeInfo(val hPX: Int, val wPX: Int, val hDP: Dp, val wDP: Dp)

@get:Composable
expect val screenSizeInfo: ScreenSizeInfo

val LocalScreenSize = compositionLocalOf<ScreenSizeInfo> { error("No Screen Size Info provided") }

@Composable
private operator fun PaddingValues.plus(paddingValues: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        bottom = calculateBottomPadding() + paddingValues.calculateBottomPadding(),
        top = calculateTopPadding() + paddingValues.calculateTopPadding(),
        start = calculateStartPadding(layoutDirection)
                + paddingValues.calculateStartPadding(layoutDirection),
        end = calculateEndPadding(layoutDirection)
                + paddingValues.calculateEndPadding(layoutDirection)
    )
}