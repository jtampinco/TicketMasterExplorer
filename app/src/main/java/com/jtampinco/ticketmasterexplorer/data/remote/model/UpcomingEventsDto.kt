package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class UpcomingEventsDto (

	@SerializedName("_total") val _total : Int,
	@SerializedName("tmr") val tmr : Int,
	@SerializedName("ticketmaster") val ticketmaster : Int
)