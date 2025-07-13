package com.example.demo.service;

import com.example.demo.client.OpenAiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for analyzing the sentiment of a text using OpenAI.
 */
@Service
@RequiredArgsConstructor
public class SentimentService {

    private final OpenAiClient openAiClient;

    /**
     * Call OpenAI to classify the sentiment of the text.
     *
     * @param text user text to analyze
     * @return POSITIVE, NEGATIVE or NEUTRAL
     */
    public String analyze(String text) {
        String systemPrompt = "You are a sentiment analysis assistant. "
                + "Classify the user text as POSITIVE, NEGATIVE or NEUTRAL. "
                + "Do not add anything else.";
        String userPrompt = systemPrompt + "\n\nText: \"" + text + "\"";

        String response = openAiClient.chat(userPrompt);
        String normalized = response.strip()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");
        if (normalized.contains("POSITIVE")) {
            return "POSITIVE";
        } else if (normalized.contains("NEGATIVE")) {
            return "NEGATIVE";
        } else {
            return "NEUTRAL";
        }
    }
}
