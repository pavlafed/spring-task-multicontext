package org.pavlafed.spring.task.multicontext.service

import org.slf4j.LoggerFactory

class MyService(private val config: ServiceProperties) {

    private val log = LoggerFactory.getLogger(MyService::class.java)

    fun doStuff() {
        log.info("Making a call to {} from {} region", config.baseUrl, config.region)
    }
}