package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class DatesDto (

	@SerializedName("start") val start : StartDto?,
	@SerializedName("timezone") val timezone : String?,
	@SerializedName("status") val status : StatusDto,
	@SerializedName("spanMultipleDays") val spanMultipleDays : Boolean
)