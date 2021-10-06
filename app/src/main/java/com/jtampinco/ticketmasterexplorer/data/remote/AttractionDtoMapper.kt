package com.jtampinco.ticketmasterexplorer.data.remote

import com.jtampinco.ticketmasterexplorer.data.domain.model.Attraction
import com.jtampinco.ticketmasterexplorer.data.domain.util.DomainMapper
import com.jtampinco.ticketmasterexplorer.data.remote.model.AttractionsDto
import com.jtampinco.ticketmasterexplorer.data.remote.util.findGoodQualityImage
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class AttractionDtoMapper @Inject constructor() : DomainMapper<AttractionsDto, Attraction> {

    override fun mapToDomainModel(model: AttractionsDto): Attraction {
        return Attraction(
            id = model.id,
            name = model.name,
            image = findGoodQualityImage(model.images),
            url = model.url ?: ""
        )
    }

    override fun mapToDomainModelList(modelList: List<AttractionsDto>): List<Attraction> {
        val newList: MutableList<Attraction> = mutableListOf()
        modelList.forEach { model ->
            newList += mapToDomainModel(model)
        }
        return newList.toImmutableList()
    }
}