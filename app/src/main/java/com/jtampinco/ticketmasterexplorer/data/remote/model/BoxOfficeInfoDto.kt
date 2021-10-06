package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeInfoDto (

	@SerializedName("phoneNumberDetail") val phoneNumberDetail : String,
	@SerializedName("openHoursDetail") val openHoursDetail : String,
	@SerializedName("acceptedPaymentDetail") val acceptedPaymentDetail : String,
	@SerializedName("willCallDetail") val willCallDetail : String
)