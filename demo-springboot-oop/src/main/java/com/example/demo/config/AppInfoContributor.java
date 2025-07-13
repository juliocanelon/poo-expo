package com.example.demo.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Contributes basic application info to the Actuator /info endpoint.
 */
@Component
public class AppInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of(
                "name", "demo-springboot-oop",
                "description", "Demo Spring Boot OOP Project",
                "version", "0.0.1-SNAPSHOT"
        ));
    }
}
