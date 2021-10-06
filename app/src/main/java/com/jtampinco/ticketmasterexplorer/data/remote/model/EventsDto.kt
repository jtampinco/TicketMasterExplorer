package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class EventsDto (

	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("id") val id : String,
	@SerializedName("test") val test : Boolean,
	@SerializedName("url") val url : String,
	@SerializedName("locale") val locale : String,
	@SerializedName("images") val images : List<ImagesDto>,
	@SerializedName("sales") val sales : SalesDto,
	@SerializedName("dates") val dates : DatesDto,
	@SerializedName("classifications") val classifications : List<ClassificationsDto>,
	@SerializedName("promoter") val promoter : PromoterDto,
	@SerializedName("promoters") val promoters : List<PromotersDto>,
	@SerializedName("pleaseNote") val pleaseNote : String,
	@SerializedName("priceRanges") val priceRanges : List<PriceRangesDto>?,
	@SerializedName("products") val products : List<ProductsDto>,
	@SerializedName("seatmap") val seatmap : SeatmapDto,
	@SerializedName("accessibility") val accessibility : AccessibilityDto,
	@SerializedName("ticketLimit") val ticketLimit : TicketLimitDto,
	@SerializedName("ageRestrictions") val ageRestrictions : AgeRestrictionsDto,
	@SerializedName("ticketing") val ticketing : TicketingDto,
	@SerializedName("_links") val _links : LinksDto,
	@SerializedName("_embedded") val _embedded : EmbeddedDto
)