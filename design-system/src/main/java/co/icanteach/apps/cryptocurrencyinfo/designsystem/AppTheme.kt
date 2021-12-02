package co.icanteach.apps.cryptocurrencyinfo.designsystem

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.color.ThemePalette
import co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.color.clickable
import co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.color.getThemePalette
import co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.typography.TypographyPalette
import co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.typography.getTypographicPalette
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.*

object AppTheme {
    val colors: ThemePalette
        @Composable
        @ReadOnlyComposable
        get() = LocalThemePalette.current
    val typography: TypographyPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

/**
 * https://medium.com/mobile-app-development-publication/android-jetpack-compose-compositionlocal-made-easy-8632b201bfcd
 */

private val LocalThemePalette = staticCompositionLocalOf<ThemePalette> {
    error("No theme palette provided")
}
private val LocalTypography = staticCompositionLocalOf<TypographyPalette> {
    error("No typography provided")
}

@Composable
fun NetflixTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    language: String = Locale.getDefault().displayLanguage,
    content: @Composable () -> Unit
) {
    val colors = remember {
        getThemePalette(
            isDarkModeOn = isDark
        )
    }.apply {
        update(
            getThemePalette(
                isDarkModeOn = isDark
            )
        )
    }

    val typographyStyle = getTypographicPalette()

    ProvideWindowInsets {
        MaterialTheme(
            colors = debugColors(isDark)
        ) {
            ProvideNetflixTheme(
                themePalette = colors,
                typographyPalette = typographyStyle,
                content = content
            )
        }
    }

    val systemUiController = rememberSystemUiController()
    if (isDark) {
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }
}


@Composable
private fun ProvideNetflixTheme(
    themePalette: ThemePalette,
    typographyPalette: TypographyPalette,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalThemePalette provides themePalette,
        LocalTypography provides typographyPalette,
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides rememberRippleTheme(),
            content = content
        )
    }
}

private fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

@Composable
fun rememberRippleTheme(
    rippleColor: Color = AppTheme.colors.clickable(),
    rippleAlpha: Float = rippleColor.alpha
) = remember {
    object : RippleTheme {
        @Composable
        override fun defaultColor() = rippleColor

        @Composable
        override fun rippleAlpha() = RippleAlpha(
            draggedAlpha = 0f,
            focusedAlpha = 0f,
            hoveredAlpha = 0f,
            pressedAlpha = rippleAlpha.toSupportAlpha()
        )
    }
}

/**
 * this func will block some crashes
 */
private fun Float.toSupportAlpha() =
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P && this > 0.49f)
        0.49f
    else
        this