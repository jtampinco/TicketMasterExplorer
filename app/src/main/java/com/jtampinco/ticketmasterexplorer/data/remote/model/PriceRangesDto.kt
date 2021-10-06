package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class PriceRangesDto (

	@SerializedName("type") val type : String,
	@SerializedName("currency") val currency : String,
	@SerializedName("min") val min : Double,
	@SerializedName("max") val max : Double
)