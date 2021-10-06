package com.jtampinco.ticketmasterexplorer.data.repository

import com.jtampinco.ticketmasterexplorer.data.base.BaseRemoteRepo
import com.jtampinco.ticketmasterexplorer.data.base.RepoResponse
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.data.remote.EventDtoMapper
import com.jtampinco.ticketmasterexplorer.data.remote.api.TicketMasterService
import javax.inject.Inject

class SearchEventRepo @Inject constructor(
    private val service: TicketMasterService,
    private val mapper: EventDtoMapper,
) : BaseRemoteRepo() {

    suspend fun search(
        apikey: String,
        keyword: String,
        page: Int,
        sizePerPage: Int,
    ): RepoResponse<List<Event>> {
        return callApi {
            val apiResponse = service.searchEvents(
                apikey = apikey,
                keyword = keyword,
                page = page,
                sizePerPage = sizePerPage,
            )._embedded?.events
            apiResponse?.map { mapper.mapToDomainModel(it) } ?: listOf()
        }
    }
}