package com.jtampinco.ticketmasterexplorer.data.remote.response

import com.google.gson.annotations.SerializedName
import com.jtampinco.ticketmasterexplorer.data.remote.model.EmbeddedDto
import com.jtampinco.ticketmasterexplorer.data.remote.model.LinksDto
import com.jtampinco.ticketmasterexplorer.data.remote.model.PageDto

data class TicketMasterResponse(
    @SerializedName("_embedded") val _embedded: EmbeddedDto?,
    @SerializedName("_links") val _links: LinksDto,
    @SerializedName("page") val page: PageDto,
)
