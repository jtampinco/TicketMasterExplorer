package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class VenuesDto (

    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("id") val id : String,
    @SerializedName("test") val test : Boolean,
    @SerializedName("url") val url : String?,
    @SerializedName("locale") val locale : String,
    @SerializedName("images") val images : List<ImagesDto>?,
    @SerializedName("postalCode") val postalCode : String,
    @SerializedName("timezone") val timezone : String,
    @SerializedName("city") val city : CityDto,
    @SerializedName("state") val state : StateDto,
    @SerializedName("country") val country : CountryDto,
    @SerializedName("address") val address : AddressDto,
    @SerializedName("location") val location : LocationDto,
    @SerializedName("markets") val markets : List<MarketsDto>,
    @SerializedName("dmas") val dmas : List<DmasDto>,
    @SerializedName("boxOfficeInfo") val boxOfficeInfo : BoxOfficeInfoDto,
    @SerializedName("parkingDetail") val parkingDetail : String,
    @SerializedName("accessibleSeatingDetail") val accessibleSeatingDetail : String,
    @SerializedName("generalInfo") val generalInfo : GeneralInfoDto,
    @SerializedName("upcomingEvents") val upcomingEvents : UpcomingEventsDto,
    @SerializedName("_links") val _links : LinksDto
)