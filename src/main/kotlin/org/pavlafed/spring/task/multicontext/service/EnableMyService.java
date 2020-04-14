package org.pavlafed.spring.task.multicontext.service;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyServiceConfiguration.class)
public @interface EnableMyService {
}
