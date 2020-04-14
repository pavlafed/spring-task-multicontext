package org.pavlafed.spring.task.multicontext.app

import org.pavlafed.spring.task.multicontext.config.eu.EuRegionConfig
import org.pavlafed.spring.task.multicontext.config.na.NaRegionConfig
import org.pavlafed.spring.task.multicontext.config.task.Task
import org.pavlafed.spring.task.multicontext.service.MessageQueue
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean
import kotlin.random.Random

@SpringBootApplication
class MultiContextApplication {

	@Bean
	fun messageGenerator(): MessageQueue {
		return MessageQueue(List(10) { Random.nextInt(0, 100) })
	}


}

fun main(args: Array<String>) {
	var parent = SpringApplicationBuilder().parent(MultiContextApplication::class.java)
			.web(WebApplicationType.NONE)

	parent.run(*args)

	parent.child(NaRegionConfig::class.java).web(WebApplicationType.NONE)
			.properties("spring.config.name=na-env").run(*args)

	parent.child(EuRegionConfig::class.java).web(WebApplicationType.NONE)
			.properties("spring.config.name=eu-env").run(*args)

	parent.child(Task::class.java).web(WebApplicationType.NONE)
			.properties("spring.config.name=task").run(*args)

}
