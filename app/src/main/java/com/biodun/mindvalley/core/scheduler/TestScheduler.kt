package com.biodun.mindvalley.core.scheduler

import io.reactivex.schedulers.Schedulers

class TestScheduler : SchedulerWrapper {
    override fun mainThread() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
    override fun computation() = Schedulers.trampoline()
}
