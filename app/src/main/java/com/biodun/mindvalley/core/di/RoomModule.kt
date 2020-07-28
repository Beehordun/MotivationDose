package com.biodun.mindvalley.core.di

import android.content.Context
import androidx.room.Room
import com.biodun.mindvalley.core.DB_NAME
import com.biodun.mindvalley.features.channel.data.cache.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideNewsResultDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }
}
