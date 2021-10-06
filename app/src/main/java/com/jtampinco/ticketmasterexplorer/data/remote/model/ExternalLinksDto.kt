package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class ExternalLinksDto (

	@SerializedName("twitter") val twitter : List<TwitterDto>,
	@SerializedName("wiki") val wiki : List<WikiDto>,
	@SerializedName("facebook") val facebook : List<FacebookDto>,
	@SerializedName("instagram") val instagram : List<InstagramDto>,
	@SerializedName("homepage") val homepage : List<HomepageDto>
)