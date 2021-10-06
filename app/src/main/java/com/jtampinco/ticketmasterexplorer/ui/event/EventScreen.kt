package com.jtampinco.ticketmasterexplorer.ui.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jtampinco.ticketmasterexplorer.ui.components.SearchAppBar
import com.jtampinco.ticketmasterexplorer.viewmodel.event.FavoriteEventViewModel
import com.jtampinco.ticketmasterexplorer.viewmodel.event.SearchEventViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventScreen(
    searchEventViewModel: SearchEventViewModel,
    favoriteEventViewModel: FavoriteEventViewModel,
    navController: NavHostController? = null,
) {
    val tabPage = searchEventViewModel.tabPage.value
    Scaffold(
        topBar = {
            EventSearchBar(searchEventViewModel)
        },
        content = {
            Column {
                EventTab(
                    selectedTabIndex = tabPage.ordinal,
                    onSelectedTab = {
                        searchEventViewModel.onTabSelected(it)

                        // TODO: Update this trigger
                        when (it) {
                            TabPage.Events -> searchEventViewModel.onExecuteSearch()
                            TabPage.Favorite -> favoriteEventViewModel.getFavorites()
                        }
                    }
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    when (tabPage) {
                        TabPage.Events -> {
                            EventListContent(
                                viewModel = searchEventViewModel,
                                navController = navController
                            )
                        }
                        TabPage.Favorite -> {
                            FavoriteEventContent(
                                viewModel = favoriteEventViewModel,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventSearchBar(
    viewModel: SearchEventViewModel,
) {
    val query = viewModel.query.value

    Column {
        SearchAppBar(
            query = query,
            onQueryChange = viewModel::onQueryChanged,
            onExecuteSearch = viewModel::onExecuteSearch
        )
    }
}

