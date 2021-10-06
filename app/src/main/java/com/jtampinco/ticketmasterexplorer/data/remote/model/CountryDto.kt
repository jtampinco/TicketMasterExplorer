package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class CountryDto (

	@SerializedName("name") val name : String,
	@SerializedName("countryCode") val countryCode : String
)