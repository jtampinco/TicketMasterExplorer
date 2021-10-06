package com.jtampinco.ticketmasterexplorer.data.domain.room

import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import kotlinx.coroutines.flow.Flow

class LocalDbImpl(
    private val roomDb: RoomDb,
) : LocalDb {

    override fun getFavoriteEvents(): Flow<List<Event>> {
        return roomDb.favoriteEventDb.getFavoriteEventsDistinctUntilChanged()
    }

    override suspend fun saveFavoriteEvent(event: Event) {
        roomDb.favoriteEventDb.saveEvent(event)
    }

    override suspend fun deleteFavoriteEvent(event: Event) {
        roomDb.favoriteEventDb.deleteEvent(event)
    }
}