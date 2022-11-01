package com.example.composeplay.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = AppGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Color.White,
    background = Color.White,
    onSurface = Color.Black,
)

private val DarkColorPalette = darkColors(
    primary = AppGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = DarkSurface,
    background = DarkSurface,
    onSurface = DarkText,
)

@Composable
fun ComposePlayTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}