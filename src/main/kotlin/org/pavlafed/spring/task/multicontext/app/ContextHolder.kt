package org.pavlafed.spring.task.multicontext.app

import org.pavlafed.spring.task.multicontext.service.MyService
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import java.lang.IllegalStateException

@Component
class ContextHolder {

    private val contexts = mutableMapOf<String, ApplicationContext>()

    fun regions() = contexts.keys.toSet()

    fun addContext(env: String, ctx: ApplicationContext) {
        contexts[env] = ctx
    }

    fun getService(region: String): MyService = contexts[region]?.getBean(MyService::class.java) ?: throw IllegalStateException("No such region: $region")
}