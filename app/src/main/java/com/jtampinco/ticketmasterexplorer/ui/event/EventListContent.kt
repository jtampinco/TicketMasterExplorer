package com.jtampinco.ticketmasterexplorer.ui.event

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationSearching
import androidx.compose.material.icons.outlined.Search
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
import com.jtampinco.ticketmasterexplorer.ui.components.LoadingListShimmer
import com.jtampinco.ticketmasterexplorer.viewmodel.ViewAttractionViewModel
import com.jtampinco.ticketmasterexplorer.viewmodel.event.SearchEventViewModel

@Composable
fun EventListContent(
    viewModel: SearchEventViewModel,
    navController: NavHostController? = null,
) {
    val events = viewModel.events.value
    val currentPage = viewModel.page.value
    val isLoading = viewModel.loading.value
    val hasError = viewModel.hasError.value

    if (events.isEmpty() && !isLoading) {
        EventListPlaceholder(
            hasError = hasError,
            retry = viewModel::onExecuteSearch
        )
    }

    EventList(
        events = events,
        currentPage = currentPage,
        isLoading = isLoading,
        onChangeListScrollPosition = viewModel::onChangeListScrollPosition,
        onLoadNextPage = viewModel::onLoadNextPage,
        onUpdateFavoriteEvents = viewModel::onUpdateFavoriteEvents,
        navController = navController
    )

    if (isLoading && events.isEmpty()) {
        LoadingListShimmer(
            isDisplayed = isLoading,
            imageHeight = 250.dp
        )
    }

    if (isLoading && events.isNotEmpty()) {
        CircularIndeterminateProgressBar(isDisplayed = isLoading)
    }
}

@Composable
fun EventList(
    events: List<Event>,
    currentPage: Int,
    isLoading: Boolean,
    onChangeListScrollPosition: (Int) -> Unit,
    onLoadNextPage: () -> Unit,
    onUpdateFavoriteEvents: (Boolean, Event) -> Unit,
    navController: NavHostController? = null,
) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(events) { index, event ->
            onChangeListScrollPosition(index)
            if ((index + 1) >= (currentPage * SearchEventViewModel.PAGE_SIZE) && !isLoading) {
                onLoadNextPage()
            }
            EventCard(
                event = event,
                onFavoriteClicked = {
                    onUpdateFavoriteEvents(it, event)
                },
                onAttractionClicked = { url ->
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
fun EventListPlaceholder(
    modifier: Modifier = Modifier,
    hasError: Boolean,
    retry: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.disabled,
        ) {
            Icon(
                modifier = Modifier.size(75.dp),
                imageVector = Icons.Outlined.Search,
                contentDescription = stringResource(id = R.string.no_results_found),
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = if (hasError) {
                    stringResource(id = R.string.default_error)
                } else {
                    stringResource(id = R.string.no_results_found)
                },
                textAlign = TextAlign.Center,
                style = typography.subtitle1,
            )
            if (hasError) {
                TextButton(onClick = retry) {
                    Text(stringResource(id = R.string.try_again))
                }
            } else {
                Text(
                    text = stringResource(id = R.string.try_new_keyword),
                    textAlign = TextAlign.Center,
                    style = typography.caption,
                )
            }
        }
    }
}