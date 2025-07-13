package com.example.demo.service;

import com.example.demo.client.OpenAiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service layer for chat operations using OpenAI.
 */
@Service
@RequiredArgsConstructor
public class ChatService {

    private final OpenAiClient openAiClient;

    /**
     * Send a chat prompt to OpenAI and return the response text.
     *
     * @param prompt user prompt
     * @return response from OpenAI
     */
    public String chat(String prompt) {
        return openAiClient.chat(prompt);
    }
}
