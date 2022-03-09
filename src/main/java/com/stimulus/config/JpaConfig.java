package com.stimulus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // 원래 Application에 있었는데 분리시킴.
public class JpaConfig {
}
