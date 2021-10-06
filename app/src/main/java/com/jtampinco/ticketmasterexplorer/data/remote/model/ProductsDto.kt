package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductsDto (

	@SerializedName("name") val name : String,
	@SerializedName("id") val id : String,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String,
	@SerializedName("classifications") val classifications : List<ClassificationsDto>
)