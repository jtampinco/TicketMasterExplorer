package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class MarketsDto (

	@SerializedName("name") val name : String,
	@SerializedName("id") val id : Int
)