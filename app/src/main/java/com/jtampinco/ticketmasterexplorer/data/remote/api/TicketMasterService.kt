package com.jtampinco.ticketmasterexplorer.data.remote.api

import com.jtampinco.ticketmasterexplorer.data.remote.response.TicketMasterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterService {

    /**
     * API to get the list of events associated to the attraction
     */
    @GET("discovery/v2/events")
    suspend fun searchEvents(
        @Query("apikey") apikey: String,
        @Query("keyword") keyword: String,
        @Query("page") page: Int,
        @Query("size") sizePerPage: Int,
    ): TicketMasterResponse

}