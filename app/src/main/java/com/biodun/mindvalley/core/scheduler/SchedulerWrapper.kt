package com.biodun.mindvalley.core.scheduler

import io.reactivex.Scheduler

interface SchedulerWrapper {
    fun mainThread(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
}
