package org.pavlafed.spring.task.multicontext

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiContextApplication

fun main(args: Array<String>) {
	runApplication<MultiContextApplication>(*args)
}
