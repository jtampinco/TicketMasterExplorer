package com.jtampinco.ticketmasterexplorer.ui.event

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class TabPage() {
    Events,
    Favorite
}

@Composable
fun EventTab(
    selectedTabIndex: Int,
    onSelectedTab: (TabPage) -> Unit,
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        TabPage.values().forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelectedTab(tabPage) },
                text = { Text(text = tabPage.name) },
                selectedContentColor = Color.LightGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.disabled)
            )
        }
    }
}