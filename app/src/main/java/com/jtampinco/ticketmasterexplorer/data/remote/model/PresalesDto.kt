package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class PresalesDto (

	@SerializedName("startDateTime") val startDateTime : String,
	@SerializedName("endDateTime") val endDateTime : String,
	@SerializedName("name") val name : String
)