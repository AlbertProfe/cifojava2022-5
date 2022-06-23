package io.company.library.utilities;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import reactor.core.publisher.Mono;

@Configuration
@EnableReactiveMongoAuditing
class DataAuditConfiguration{

    @Bean
    ReactiveAuditorAware<String> auditorAware() {
        return () -> Mono.just("Albert Profe CIFO JAVA 2022");
    }
}