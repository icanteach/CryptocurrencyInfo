package co.icanteach.apps.cryptocurrencyinfo.designsystem.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.icanteach.apps.cryptocurrencyinfo.designsystem.R

internal fun getTypographicPalette() = typographyPaletteRoman()


private val typographyMono = FontFamily(
    Font(R.font.noto_sans_mono_regular, FontWeight.Normal),
    Font(R.font.noto_sans_mono_medium, FontWeight.Medium),
    Font(R.font.noto_sans_mono_bold, FontWeight.SemiBold)
)

private fun typographyPaletteRoman() = TypographyPalette(
    theme = TypographyTheme.ROMAN,
    body = TextStyle(
        fontFamily = typographyMono,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    buttonDefault = TextStyle(
        fontFamily = typographyMono,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    labelDefault = TextStyle(
        fontFamily = typographyMono,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    heading = TextStyle(
        fontFamily = typographyMono,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    )
)