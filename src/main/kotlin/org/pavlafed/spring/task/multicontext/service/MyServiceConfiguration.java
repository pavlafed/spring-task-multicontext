package org.pavlafed.spring.task.multicontext.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class MyServiceConfiguration {

    @Bean
    public MyService myService(final ServiceProperties props) {
        return new MyService(props);
    }
}
