package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class AttractionsDto (

	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("id") val id : String,
	@SerializedName("test") val test : Boolean,
	@SerializedName("url") val url : String?,
	@SerializedName("locale") val locale : String,
	@SerializedName("externalLinks") val externalLinks : ExternalLinksDto,
	@SerializedName("images") val images : List<ImagesDto>,
	@SerializedName("classifications") val classifications : List<ClassificationsDto>,
	@SerializedName("upcomingEvents") val upcomingEvents : UpcomingEventsDto,
	@SerializedName("_links") val _links : LinksDto
)