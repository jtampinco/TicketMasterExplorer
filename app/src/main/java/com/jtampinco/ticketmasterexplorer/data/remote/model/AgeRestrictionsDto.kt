package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class AgeRestrictionsDto (

	@SerializedName("legalAgeEnforced") val legalAgeEnforced : Boolean
)