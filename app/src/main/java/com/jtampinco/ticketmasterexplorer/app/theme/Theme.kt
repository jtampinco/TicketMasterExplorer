package com.jtampinco.ticketmasterexplorer.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Indigo200,
    primaryVariant = Indigo700,
    secondary = Green200
)

private val LightColorPalette = lightColors(
    primary = Indigo500,
    primaryVariant = Indigo700,
    secondary = Green200
)

@Composable
fun MyDefaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}