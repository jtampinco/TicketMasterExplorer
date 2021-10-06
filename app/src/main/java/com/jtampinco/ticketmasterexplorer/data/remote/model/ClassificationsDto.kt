package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class ClassificationsDto (

	@SerializedName("primary") val primary : Boolean,
	@SerializedName("segment") val segment : SegmentDto,
	@SerializedName("genre") val genre : GenreDto,
	@SerializedName("subGenre") val subGenre : SubGenreDto,
	@SerializedName("type") val type : TypeDto,
	@SerializedName("subType") val subType : SubTypeDto,
	@SerializedName("family") val family : Boolean
)