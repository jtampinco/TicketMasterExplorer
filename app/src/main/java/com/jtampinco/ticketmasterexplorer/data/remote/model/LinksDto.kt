package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class LinksDto (

	@SerializedName("first") val first : FirstDto,
	@SerializedName("self") val self : SelfDto,
	@SerializedName("next") val next : NextDto,
	@SerializedName("last") val last : LastDto
)