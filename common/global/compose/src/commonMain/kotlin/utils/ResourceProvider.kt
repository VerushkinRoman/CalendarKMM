package utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import di.Inject
import domain.StringProvider

object ResourceProvider {
    private val stringProvider = StringProvider(Inject.instance())

    fun getString(stringResource: StringResource, args: List<Any>? = null) =
        stringProvider.getString(stringResource, args)

    @Composable
    fun getPainter(imageResource: ImageResource): Painter = painterResource(imageResource)

    @Composable
    fun getColor(colorResource: ColorResource): Color = colorResource(colorResource)
}