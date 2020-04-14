package org.pavlafed.spring.task.multicontext.config.task

import org.pavlafed.spring.task.multicontext.app.ContextHolder
import org.pavlafed.spring.task.multicontext.service.MessageQueue
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableTask
class Task(private val regions: ContextHolder, private val queue: MessageQueue) {

    private val log = LoggerFactory.getLogger(Task::class.java)

    @Bean
    fun taskConfigurer(ds: DataSource) = DefaultTaskConfigurer(ds)

    @Bean
    fun commandLineRunner() = CommandLineRunner { _ ->
        val work = queue.getWork()
        log.info("Starting task with $work")

        work.forEach {
            val requestRegion = regionMapper(it)
            log.info("Processing $it for region $requestRegion")
            regions.getService(requestRegion).doStuff()
        }
    }

    private fun regionMapper(n: Int) =
            if (n % 2 == 0) "eu"
            else "na"


}