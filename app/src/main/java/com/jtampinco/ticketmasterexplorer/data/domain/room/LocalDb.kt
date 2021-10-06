package com.jtampinco.ticketmasterexplorer.data.domain.room

import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface LocalDb {

    fun getFavoriteEvents(): Flow<List<Event>>
    suspend fun saveFavoriteEvent(event: Event)
    suspend fun deleteFavoriteEvent(event: Event)

}