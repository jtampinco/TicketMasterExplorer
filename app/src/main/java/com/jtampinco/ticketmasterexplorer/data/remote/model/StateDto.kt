package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class StateDto (

	@SerializedName("name") val name : String,
	@SerializedName("stateCode") val stateCode : String
)