package co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.color

import androidx.compose.ui.graphics.Color

internal fun getThemePalette(
    isDarkModeOn: Boolean
) = when {
    isDarkModeOn -> darkColors()
    else -> lightColors()
}

private fun lightColors() = ThemePalette(
    theme = ColorTheme.LIGHT,
    bgTheme = black10,
    bgOverlay = black,
    onPrimary = blue10,
    onSecondary = white,
    error = purple10,
    info = purple10,
    success = purple10
)

private fun darkColors() = ThemePalette(
    theme = ColorTheme.DARK,
    bgTheme = black10,
    bgOverlay = black,
    onPrimary = blue10,
    onSecondary = black,
    error = black,
    info = black,
    success = black
)


private val black10 = Color(0xFF111820)
private val blue10 = Color(0xFF4B97C5)

private val black = Color(0xFF000000)
private val white = Color(0xFFFFFFFF)
private val gray10 = Color(0xFFE6E6E6)
private val purple10 = Color(0xFFDACCD2)
private val pink10 = Color(0xFFFFF4F2)