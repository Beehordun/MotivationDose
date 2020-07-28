package com.biodun.mindvalley.core.di

import com.biodun.mindvalley.core.scheduler.AppSchedulerWrapper
import com.biodun.mindvalley.core.scheduler.SchedulerWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class CoreModule {
    @Binds
    abstract fun bindSchedulerWrapper(
        appSchedulerWrapper: AppSchedulerWrapper
    ): SchedulerWrapper
}
