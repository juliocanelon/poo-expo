package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Minimal OpenAI client wrapper used for demo purposes.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OpenAiClient {

    @Value("${OPENAI_API_KEY:}")
    private String apiKey;

    public String chat(String prompt) {
        if (apiKey == null || apiKey.isBlank()) {
            return "OpenAI disabled (demo)";
        }
        // In a real implementation you would call OpenAI here
        log.info("Would call OpenAI with prompt: {}", prompt);
        return "OpenAI response placeholder";
    }
}
