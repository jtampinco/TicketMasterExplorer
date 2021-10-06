package com.jtampinco.ticketmasterexplorer.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jtampinco.ticketmasterexplorer.ui.components.HeartState.ACTIVE
import com.jtampinco.ticketmasterexplorer.ui.components.HeartState.IDLE

private enum class HeartState {
    IDLE, ACTIVE
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedHeartButton(
    modifier: Modifier,
    initialIconSize: Dp = 24.dp,
    expandedIconSize: Dp = 32.dp,
    isSelected: Boolean,
    onButtonClicked: (Boolean) -> Unit,
) {
    // Fix bug in the heart state
    // Maybe it would be better to put it inside the viewmodel
    var heartState by remember { mutableStateOf(if (isSelected) ACTIVE else IDLE) }
    val transition = updateTransition(targetState = heartState, label = "")

    val color by transition.animateColor(label = "") { state ->
        when (state) {
            IDLE -> Color.DarkGray.copy(.9f)
            ACTIVE -> Color.Red.copy(.9f)
        }
    }

    val size by transition.animateDp(label = "", transitionSpec = {
        keyframes {
            durationMillis = 500
            expandedIconSize at 100
            initialIconSize at 200
        }
    }) { state ->
        when (state) {
            IDLE, ACTIVE -> initialIconSize
        }
    }

    Column(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier
                .size(size)
                .clickable {
                    heartState = when (heartState) {
                        IDLE -> ACTIVE
                        ACTIVE -> IDLE
                    }
                    onButtonClicked(
                        when (heartState) {
                            IDLE -> false
                            ACTIVE -> true
                        }
                    )
                },
            imageVector = Icons.Filled.Favorite,
            contentDescription = "",
            tint = color
        )
    }
}