package com.jtampinco.ticketmasterexplorer.data.remote

import com.jtampinco.ticketmasterexplorer.data.domain.model.Venue
import com.jtampinco.ticketmasterexplorer.data.domain.util.DomainMapper
import com.jtampinco.ticketmasterexplorer.data.remote.model.VenuesDto
import com.jtampinco.ticketmasterexplorer.data.remote.util.findGoodQualityImage
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class VenueDtoMapper @Inject constructor() : DomainMapper<VenuesDto, Venue> {
    override fun mapToDomainModel(model: VenuesDto): Venue {
        return Venue(
            id = model.id,
            name = model.name,
            image = model.images?.let { findGoodQualityImage(it) } ?: "",
            url = model.url ?: ""
        )
    }

    override fun mapToDomainModelList(modelList: List<VenuesDto>): List<Venue> {
        val newList: MutableList<Venue> = mutableListOf()
        modelList.forEach { model ->
            newList += mapToDomainModel(model)
        }
        return newList.toImmutableList()
    }

}