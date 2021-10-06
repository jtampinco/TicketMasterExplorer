package com.jtampinco.ticketmasterexplorer.di

import com.jtampinco.ticketmasterexplorer.data.SearchEvent
import com.jtampinco.ticketmasterexplorer.data.repository.SearchEventImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GithubSearchClass() {

    @Binds
    abstract fun bindGithubSearchRepository(
        searchAttractionImpl: SearchEventImpl,
    ): SearchEvent

}