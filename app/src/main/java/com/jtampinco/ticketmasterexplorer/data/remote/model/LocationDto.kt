package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationDto (

	@SerializedName("longitude") val longitude : Double,
	@SerializedName("latitude") val latitude : Double
)