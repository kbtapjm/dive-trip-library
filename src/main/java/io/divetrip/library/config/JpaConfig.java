package io.divetrip.library.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "io.divetrip.library.domain")
@EnableJpaRepositories(basePackages = "io.divetrip.library.domain.repository")
public class JpaConfig {
}
