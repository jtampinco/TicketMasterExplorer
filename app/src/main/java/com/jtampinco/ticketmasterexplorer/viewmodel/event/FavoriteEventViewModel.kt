package com.jtampinco.ticketmasterexplorer.viewmodel.event

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.data.domain.room.LocalDb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterialApi::class)
@HiltViewModel
class FavoriteEventViewModel @Inject constructor(
    private val localDb: LocalDb,
) : ViewModel() {

    private val _events = mutableStateOf(listOf<Event>())
    val events: State<List<Event>> = _events

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    init {
        getFavorites()
    }

    fun getFavorites() = viewModelScope.launch {
        localDb.getFavoriteEvents().collect {
            _loading.value = true
            delay(300)
            _events.value = it
            _loading.value = false
        }
    }

    fun onUpdateFavoriteEvents(isFavorite: Boolean, event: Event) = viewModelScope.launch {
        event.isFavorite = isFavorite
        if (isFavorite) {
            localDb.saveFavoriteEvent(event)
        } else {
            localDb.deleteFavoriteEvent(event)
        }
        getFavorites()
    }
}