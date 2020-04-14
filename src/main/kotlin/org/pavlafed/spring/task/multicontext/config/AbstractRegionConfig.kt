package org.pavlafed.spring.task.multicontext.config

import org.pavlafed.spring.task.multicontext.app.ContextHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener

abstract class AbstractRegionConfig(private val region: String): ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    lateinit var contextHolder: ContextHolder

    override fun onApplicationEvent(e: ApplicationStartedEvent) {
        contextHolder.addContext(region, e.applicationContext)
    }
}