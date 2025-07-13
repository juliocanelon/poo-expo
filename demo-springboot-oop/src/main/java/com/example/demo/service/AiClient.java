package com.example.demo.service;

/**
 * Generic AI chat client interface.
 */
public interface AiClient {
    /**
     * Send a prompt and get the AI response.
     */
    String chat(String prompt);
}
