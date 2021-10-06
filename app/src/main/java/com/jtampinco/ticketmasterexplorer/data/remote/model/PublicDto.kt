package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class PublicDto (

	@SerializedName("startDateTime") val startDateTime : String,
	@SerializedName("startTBD") val startTBD : Boolean,
	@SerializedName("startTBA") val startTBA : Boolean,
	@SerializedName("endDateTime") val endDateTime : String
)