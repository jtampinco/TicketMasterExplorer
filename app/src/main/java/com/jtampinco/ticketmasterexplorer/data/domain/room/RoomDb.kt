package com.jtampinco.ticketmasterexplorer.data.domain.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.data.domain.room.dao.FavoriteEventDao

@Database(
    entities = [
        Event::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class RoomDb : RoomDatabase() {
    abstract val favoriteEventDb: FavoriteEventDao

    companion object {
        private var roomDb: RoomDb? = null

        fun getInstance(context: Context): RoomDb {
            if (roomDb == null) {
                val appContext = context.applicationContext
                val clazz = RoomDb::class.java
                val dbName = "project.db"

                roomDb = Room
                    .databaseBuilder(appContext, clazz, dbName)
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                        }
                    }).build()
            }
            return roomDb as RoomDb
        }
    }


}