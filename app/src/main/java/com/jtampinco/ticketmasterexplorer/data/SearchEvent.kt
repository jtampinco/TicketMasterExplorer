package com.jtampinco.ticketmasterexplorer.data

import com.jtampinco.ticketmasterexplorer.data.base.RepoResponse
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event

interface SearchEvent {

    suspend fun search(
        apikey: String,
        keyword: String,
        page: Int,
        sizePerPage: Int,
    ): RepoResponse<List<Event>>

}