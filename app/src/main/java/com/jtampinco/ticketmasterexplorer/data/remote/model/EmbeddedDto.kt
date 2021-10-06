package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class EmbeddedDto (

	@SerializedName("events") val events : List<EventsDto>?,
	@SerializedName("attractions") val attractions: List<AttractionsDto>?,
	@SerializedName("venues") val venues: List<VenuesDto>?
)