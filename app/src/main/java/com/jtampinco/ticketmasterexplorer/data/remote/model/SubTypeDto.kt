package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class SubTypeDto (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String
)