package com.jtampinco.ticketmasterexplorer.di

import android.app.Application
import com.jtampinco.ticketmasterexplorer.data.domain.room.LocalDb
import com.jtampinco.ticketmasterexplorer.data.domain.room.LocalDbImpl
import com.jtampinco.ticketmasterexplorer.data.domain.room.RoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {

    @Provides
    fun provideLocalDb(
        application: Application,
    ): LocalDb {
        val database = RoomDb.getInstance(application)
        return LocalDbImpl(database)
    }
}