package org.pavlafed.spring.task.multicontext.service

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("service")
class ServiceProperties {
    var region: String = ""
    var baseUrl: String = ""
}