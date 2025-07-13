package com.example.demo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.Instant;
import java.util.*;

/**
 * Request: bean con alcance por petición HTTP, genera un ID único para cada solicitud.
 */
@Slf4j
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestIdentifier {
    private final String id;
    private final Instant createdAt;

    public RequestIdentifier() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Instant.now();
        log.info("[Request] RequestIdentifier instantiated: {} with id={} at {}", this.hashCode(), id, createdAt);
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
