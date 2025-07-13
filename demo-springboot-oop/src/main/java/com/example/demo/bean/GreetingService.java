package com.example.demo.bean;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Singleton scoped greeting service.
 */
@Service
@Slf4j
public class GreetingService {

    public GreetingService() {
        log.info("GreetingService created: {}", this.hashCode());
    }

    @PostConstruct
    public void init() {
        log.info("GreetingService initialized");
    }

    public String greet(String name) {
        return "Hello " + name;
    }
}
