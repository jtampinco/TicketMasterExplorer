package com.jtampinco.ticketmasterexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class TicketingDto (

    @SerializedName("healthCheck") val healthCheck : HealthCheckDto,
    @SerializedName("safeTix") val safeTix : SafeTixDto
)