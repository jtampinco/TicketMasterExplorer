package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class SalesDto (

	@SerializedName("public") val public : PublicDto,
	@SerializedName("presales") val presales : List<PresalesDto>
)