package com.jtampinco.ticketmasterexplorer.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingListShimmer(
    isDisplayed: Boolean,
    imageHeight: Dp,
    padding: Dp = 8.dp,
) {
    if (isDisplayed) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val cardWidthPx = with(LocalDensity.current) { (maxWidth - (padding * 2)).toPx() }
            val cardHeightPx = with(LocalDensity.current) { (imageHeight - (padding * 2)).toPx() }
            val gradientWidth: Float = (0.2f * cardHeightPx)

            val infiniteTransition = rememberInfiniteTransition()
            val xCardShimmer = infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = (cardWidthPx + gradientWidth),
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1500,
                        easing = LinearEasing,
                        delayMillis = 300
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
            val yCardShimmer = infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = (cardHeightPx + gradientWidth),
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 3000,
                        easing = LinearEasing,
                        delayMillis = 300
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )

            val colors = if (isSystemInDarkTheme()) {
                listOf(
                    Color.LightGray.copy(alpha = .1f),
                    Color.LightGray.copy(alpha = .4f),
                    Color.LightGray.copy(alpha = .1f)
                )
            } else {
                listOf(
                    Color.LightGray.copy(alpha = .9f),
                    Color.LightGray.copy(alpha = .6f),
                    Color.LightGray.copy(alpha = .9f)
                )
            }

            LazyColumn {
                items(5) {
                    ShimmerCardItem(
                        colors = colors,
                        xShimmer = xCardShimmer.value,
                        yShimmer = yCardShimmer.value,
                        cardHeight = imageHeight,
                        gradientWidth = gradientWidth,
                        padding = padding
                    )
                }
            }
        }
    }
}