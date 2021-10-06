package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class HealthCheckDto (

	@SerializedName("summary") val summary : String,
	@SerializedName("description") val description : String,
	@SerializedName("learnMoreUrl") val learnMoreUrl : String
)