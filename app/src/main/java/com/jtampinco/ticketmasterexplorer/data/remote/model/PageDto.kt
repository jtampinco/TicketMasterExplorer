package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class PageDto (

	@SerializedName("size") val size : Int,
	@SerializedName("totalElements") val totalElements : Int,
	@SerializedName("totalPages") val totalPages : Int,
	@SerializedName("number") val number : Int
)