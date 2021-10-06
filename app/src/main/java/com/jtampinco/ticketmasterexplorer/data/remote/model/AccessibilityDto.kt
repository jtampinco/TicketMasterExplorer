package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class AccessibilityDto (

	@SerializedName("ticketLimit") val ticketLimit : Int
)