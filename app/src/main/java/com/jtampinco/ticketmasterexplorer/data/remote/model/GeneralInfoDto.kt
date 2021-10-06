package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class GeneralInfoDto (

	@SerializedName("generalRule") val generalRule : String,
	@SerializedName("childRule") val childRule : String
)