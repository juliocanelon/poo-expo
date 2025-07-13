package com.example.demo.bean;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Singleton: servicio global que acumula estadísticas de productos.
 * Instancia única, mantiene conteos durante toda la vida de la aplicación.
 */
@Slf4j
@Service
public class ProductStatsService {
    private final AtomicLong totalCreated = new AtomicLong(0);
    private final Instant startedAt;

    public ProductStatsService() {
        this.startedAt = Instant.now();
        log.info("[Singleton] ProductStatsService instantiated: {}", this.hashCode());
    }

    @PostConstruct
    public void init() {
        log.info("Service started at: {}", startedAt);
    }

    /**
     * Incrementa el contador de productos creados.
     */
    public void recordCreation() {
        long count = totalCreated.incrementAndGet();
        log.info("Recorded a new product, total now = {}", count);
    }

    /**
     * Retorna estadísticas resumidas.
     */
    public Map<String, Object> getStats() {
        return Map.of(
                "startedAt", startedAt,
                "totalProductsCreated", totalCreated.get(),
                "instanceHash", this.hashCode()
        );
    }
}