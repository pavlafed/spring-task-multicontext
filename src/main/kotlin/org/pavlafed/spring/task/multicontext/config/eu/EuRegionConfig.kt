package org.pavlafed.spring.task.multicontext.config.eu

import org.pavlafed.spring.task.multicontext.config.AbstractRegionConfig
import org.pavlafed.spring.task.multicontext.service.EnableMyService
import org.springframework.context.annotation.Configuration

@Configuration
@EnableMyService
class EuRegionConfig : AbstractRegionConfig("eu")
