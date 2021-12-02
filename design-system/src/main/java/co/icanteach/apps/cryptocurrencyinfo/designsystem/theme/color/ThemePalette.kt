package co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

class ThemePalette(
    theme: ColorTheme,
    bgTheme: Color,
    bgOverlay: Color,
    onPrimary: Color,
    onSecondary: Color,
    error: Color,
    info: Color,
    success: Color,
) {
    var theme by mutableStateOf(theme, structuralEqualityPolicy())
        private set
    var bgTheme by mutableStateOf(bgTheme, structuralEqualityPolicy())
        private set
    var bgOverlay by mutableStateOf(bgOverlay, structuralEqualityPolicy())
        private set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        private set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        private set
    var success by mutableStateOf(success, structuralEqualityPolicy())
        private set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        private set
    var info by mutableStateOf(info, structuralEqualityPolicy())
        private set

    fun update(newTheme: ThemePalette) {
        theme = newTheme.theme
        bgTheme = newTheme.bgTheme
        bgOverlay = newTheme.bgOverlay
        onPrimary = newTheme.onPrimary
        onSecondary = newTheme.onSecondary
        error = newTheme.error
        info = newTheme.info
        success = newTheme.success
    }
}