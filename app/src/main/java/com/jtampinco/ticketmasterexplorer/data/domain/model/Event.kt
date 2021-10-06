package com.jtampinco.ticketmasterexplorer.data.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Event_tbl")
@Parcelize
data class Event(
    @PrimaryKey
    @ColumnInfo(name = "event_id")
    val id: String,

    @ColumnInfo(name = "event_name")
    val name: String = "",

    @ColumnInfo(name = "event_image")
    val image: String? = "",

    @ColumnInfo(name = "event_url")
    val url: String = "",

    @ColumnInfo(name = "event_date")
    val date: String = "",

    @ColumnInfo(name = "event_timezone")
    val timezone: String = "",

    @ColumnInfo(name = "event_price_ranges")
    val priceRanges: List<String> = emptyList(),

    @ColumnInfo(name = "event_venues")
    val venues: List<Venue> = emptyList(),

    @ColumnInfo(name = "event_attractions")
    val attractions: List<Attraction> = emptyList(),

    @ColumnInfo(name = "event_is_favorite")
    var isFavorite: Boolean = false,
) : Parcelable



