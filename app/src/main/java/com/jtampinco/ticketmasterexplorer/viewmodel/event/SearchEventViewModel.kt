package com.jtampinco.ticketmasterexplorer.viewmodel.event

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jtampinco.ticketmasterexplorer.data.SearchEvent
import com.jtampinco.ticketmasterexplorer.data.base.RepoResponse
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.data.domain.room.LocalDb
import com.jtampinco.ticketmasterexplorer.ui.event.TabPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterialApi::class)
@HiltViewModel
class SearchEventViewModel @Inject constructor(
    private val repository: SearchEvent,
    private val localDb: LocalDb,
) : ViewModel() {

    private val _tabPage = mutableStateOf(TabPage.Events)
    val tabPage: State<TabPage> = _tabPage

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    private val _events = mutableStateOf(listOf<Event>())
    val events: State<List<Event>> = _events

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    private val _searchSettingsVisibility = mutableStateOf(false)
    val searchSettingsVisibility: State<Boolean> = _searchSettingsVisibility

    private val _page = mutableStateOf(PAGE_START)
    val page: State<Int> = _page

    private val _hasError = mutableStateOf(false)
    val hasError: State<Boolean> = _hasError

    private var listScrollPosition = 0

    init {
        onExecuteSearch()
    }

    fun onTabSelected(tabPage: TabPage) {
        _tabPage.value = tabPage
    }

    fun onExecuteSearch() = viewModelScope.launch {
        onTabSelected(TabPage.Events)
        _loading.value = true
        if (_query.value.isNotEmpty()) {
            resetSearchState()

            // Adding a delay to prevent throttling the github api
            // TODO Build a better solution
            delay(1000)

            when (val response = repository.search(
                apikey = API_KEY,
                keyword = _query.value,
                page = _page.value,
                sizePerPage = PAGE_SIZE
            )) {
                is RepoResponse.Success -> {
                    _events.value = response.data
                    _hasError.value = false
                }
                is RepoResponse.Failed -> {
                    // Handle server error
                    _hasError.value = true
                }
                is RepoResponse.Error -> {
                    response.error.printStackTrace()
                    // Handle internet issue
                    _hasError.value = true
                }
            }
        }
        _loading.value = false
    }

    fun onLoadNextPage() {
        viewModelScope.launch {
            // prevent duplicate events due to recompose happening too quickly
            if ((listScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
                _loading.value = true
                incrementPage()
                if (page.value > 0) {
                    when (val response = repository.search(
                        apikey = API_KEY,
                        keyword = _query.value,
                        page = _page.value,
                        sizePerPage = PAGE_SIZE
                    )) {
                        is RepoResponse.Success -> {
                            appendRepositories(response.data)
                            _hasError.value = false
                        }
                        is RepoResponse.Failed -> {
                            // Handle server error
                            _hasError.value = true
                        }
                        is RepoResponse.Error -> {
                            response.error.printStackTrace()
                            // Handle internet issue
                            _hasError.value = true
                        }
                    }
                }
                _loading.value = false
            }
        }
    }

    fun onQueryChanged(query: String) {
        _query.value = query
    }

    fun onChangeListScrollPosition(position: Int) {
        listScrollPosition = position
    }

    fun showSearchSettings(visibility: Boolean) {
        _searchSettingsVisibility.value = visibility
    }


    fun onUpdateFavoriteEvents(isFavorite: Boolean, event: Event) = viewModelScope.launch {
        event.isFavorite = isFavorite
        if (isFavorite) {
            localDb.saveFavoriteEvent(event)
        } else {
            localDb.deleteFavoriteEvent(event)
        }
    }


    /**
     * Append new repositories to the current list of repositories
     */
    private fun appendRepositories(repositories: List<Event>) {
        val current = ArrayList(this._events.value)
        current.addAll(repositories)
        this._events.value = current
    }

    private fun resetSearchState() {
        onTabSelected(TabPage.Events)
        _events.value = listOf()
        _page.value = PAGE_START
        listScrollPosition = 0
    }

    private fun incrementPage() {
        _page.value = page.value + 1
    }

    companion object {
        const val PAGE_START = 0
        const val PAGE_SIZE = 30
        const val API_KEY = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0"
    }

}
