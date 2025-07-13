package com.example.demo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.util.*;

/**

 * Session: bean por sesión HTTP, persiste mientras dure la sesión del usuario.
 */
@Slf4j
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private final List<String> items = new ArrayList<>();

    public ShoppingCart() {
        log.info("[Session] ShoppingCart instantiated: {}", this.hashCode());
    }

    /**
     * Agrega un producto al carrito.
     */
    public void addItem(String productId) {
        items.add(productId);
        log.info("Added product '{}' to cart. Current items: {}", productId, items);
    }

    /**
     * Elimina un producto del carrito.
     */
    public boolean removeItem(String productId) {
        boolean removed = items.remove(productId);
        log.info("Removed product '{}' from cart: {}. Remaining items: {}", productId, removed, items);
        return removed;
    }

    /**
     * Recupera los productos en el carrito.
     */
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Limpia el carrito de la sesión.
     */
    public void clear() {
        items.clear();
        log.info("Cleared shopping cart.");
    }
}

