package com.jtampinco.ticketmasterexplorer.ui.event

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import com.jtampinco.ticketmasterexplorer.R
import com.jtampinco.ticketmasterexplorer.app.theme.typography
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.ui.components.CircularIndeterminateProgressBar
import com.jtampinco.ticketmasterexplorer.viewmodel.ViewAttractionViewModel
import com.jtampinco.ticketmasterexplorer.viewmodel.event.FavoriteEventViewModel

@Composable
fun FavoriteEventContent(
    viewModel: FavoriteEventViewModel,
    navController: NavHostController? = null,
) {
    val events = viewModel.events.value
    val isLoading = viewModel.loading.value

    if (events.isNotEmpty()) {
        FavoriteEventList(
            events = events,
            onUpdateFavoriteEvents = viewModel::onUpdateFavoriteEvents,
            navController = navController
        )
    } else {
        FavoriteEventListPlaceholder()
    }

    if (isLoading) {
        CircularIndeterminateProgressBar(isDisplayed = isLoading)
    }

}

@Composable
fun FavoriteEventList(
    events: List<Event>,
    onUpdateFavoriteEvents: (Boolean, Event) -> Unit,
    navController: NavHostController? = null,
) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(events) { event ->
            EventCard(
                event = event,
                onFavoriteClicked = {
                    onUpdateFavoriteEvents(it, event)
                },
                onAttractionClicked = { url ->
                    // Unfortunately the link for attractions are broken
                    navController?.navigate(
                        navController.findDestination("ViewAttractionScreen")!!.id,
                        bundleOf(Pair(ViewAttractionViewModel.ATTRACTION_URL, url))
                    )
                }
            )
        }
    }
}

@Composable
fun FavoriteEventListPlaceholder() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.disabled,
        ) {
            Icon(
                modifier = Modifier.size(75.dp),
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = stringResource(id = R.string.no_results_found),
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.no_results_found),
                textAlign = TextAlign.Center,
                style = typography.subtitle1,
            )
            Text(
                text = stringResource(id = R.string.empty_favorites),
                textAlign = TextAlign.Center,
                style = typography.caption,
            )
        }
    }
}
