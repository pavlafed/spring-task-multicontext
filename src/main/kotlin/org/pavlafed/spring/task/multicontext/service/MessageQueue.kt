package org.pavlafed.spring.task.multicontext.service

class MessageQueue(private val list: List<Int>) {

    fun getWork():List<Int> = list
}