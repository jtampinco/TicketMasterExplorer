package com.jtampinco.ticketmasterexplorer.data.domain.room.dao

import androidx.room.*
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface FavoriteEventDao {

    @Query("DELETE FROM EVENT_TBL")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEvent(event: Event)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEvents(events: List<Event>)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Query("SELECT * FROM EVENT_TBL WHERE event_is_favorite = 1")
    fun getFavoriteEvents(): Flow<List<Event>>

    fun getFavoriteEventsDistinctUntilChanged(): Flow<List<Event>> {
        return getFavoriteEvents().distinctUntilChanged()
    }
}