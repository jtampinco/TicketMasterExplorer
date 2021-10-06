package com.jtampinco.ticketmasterexplorer.data.remote

import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.data.domain.util.DomainMapper
import com.jtampinco.ticketmasterexplorer.data.remote.model.EventsDto
import com.jtampinco.ticketmasterexplorer.data.remote.model.PriceRangesDto
import com.jtampinco.ticketmasterexplorer.data.remote.model.StartDto
import com.jtampinco.ticketmasterexplorer.data.remote.util.findGoodQualityImage
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class EventDtoMapper @Inject constructor(
    private val attractionDtoMapper: AttractionDtoMapper,
    private val venueDtoMapper: VenueDtoMapper,
) : DomainMapper<EventsDto, Event> {
    override fun mapToDomainModel(model: EventsDto): Event {
        return Event(
            id = model.id,
            name = model.name,
            image = findGoodQualityImage(model.images),
            url = model.url,
            date = formatDate(model.dates.start),
            timezone = model.dates.timezone ?: "",
            priceRanges = model.priceRanges?.let { formatPriceRanges(it) } ?: listOf(),
            venues = model._embedded.venues?.let { venueDtoMapper.mapToDomainModelList(it) }
                ?: listOf(),
            attractions = model._embedded.attractions?.let {
                attractionDtoMapper.mapToDomainModelList(it)
            } ?: listOf()
        )
    }

    override fun mapToDomainModelList(modelList: List<EventsDto>): List<Event> {
        val newList: MutableList<Event> = mutableListOf()
        modelList.forEach { model ->
            newList += mapToDomainModel(model)
        }
        return newList.toImmutableList()
    }

    private fun formatDate(date: StartDto?): String {
        date?.apply {
            return when {
                dateTBD -> "Date to be determined"
                dateTBA -> "Date to be announced"
                timeTBA -> "Time to be announced"
                noSpecificTime -> "Undetermined"
                else -> {
                    val dateTime =
                        LocalDateTime.parse(date.dateTime, DateTimeFormatter.ISO_DATE_TIME)
                    dateTime.format(DateTimeFormatter.ofPattern(DATE_FORMAT)).toString()
                }
            }
        }
        return "Coming soon"
    }

    private fun formatPriceRanges(priceRange: List<PriceRangesDto>): List<String> {
        val result: MutableList<String> = mutableListOf()
        for (price in priceRange) {
            price.apply {
                result.add("$min - $max $currency")
            }
        }
        return result.toImmutableList()
    }

    companion object {
        private const val DATE_FORMAT = "MMMM dd, yyyy hh:mm a"
    }
}