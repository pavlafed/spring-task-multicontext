package org.pavlafed.spring.task.multicontext.config.na

import org.pavlafed.spring.task.multicontext.config.AbstractRegionConfig
import org.pavlafed.spring.task.multicontext.service.EnableMyService
import org.springframework.context.annotation.Configuration

@Configuration
@EnableMyService
class NaRegionConfig : AbstractRegionConfig("na")