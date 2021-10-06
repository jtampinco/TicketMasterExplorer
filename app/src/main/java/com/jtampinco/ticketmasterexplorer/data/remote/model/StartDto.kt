package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class StartDto (

	@SerializedName("localDate") val localDate : String,
	@SerializedName("localTime") val localTime : String,
	@SerializedName("dateTime") val dateTime : String,
	@SerializedName("dateTBD") val dateTBD : Boolean,
	@SerializedName("dateTBA") val dateTBA : Boolean,
	@SerializedName("timeTBA") val timeTBA : Boolean,
	@SerializedName("noSpecificTime") val noSpecificTime : Boolean
)