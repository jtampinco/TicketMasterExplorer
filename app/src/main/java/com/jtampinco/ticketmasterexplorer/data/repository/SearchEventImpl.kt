package com.jtampinco.ticketmasterexplorer.data.repository

import com.jtampinco.ticketmasterexplorer.data.SearchEvent
import com.jtampinco.ticketmasterexplorer.data.base.RepoResponse
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import javax.inject.Inject

class SearchEventImpl @Inject constructor(
    private val searchEvent: SearchEventRepo,
) : SearchEvent {

    override suspend fun search(
        apikey: String,
        keyword: String,
        page: Int,
        sizePerPage: Int,
    ): RepoResponse<List<Event>> {
        return searchEvent.search(
            apikey = apikey,
            keyword = keyword,
            page = page,
            sizePerPage = sizePerPage
        )
    }

}