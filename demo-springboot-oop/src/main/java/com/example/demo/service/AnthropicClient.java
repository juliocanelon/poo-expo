package com.example.demo.service;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Anthropic Claude client implementation.
 */
@Service
@Primary
public class AnthropicClient implements AiClient {

    private final com.anthropic.client.AnthropicClient client;

    public AnthropicClient(@Value("${ANTHROPIC_API_KEY}") String apiKey) {
        this.client = AnthropicOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    @Override
    public String chat(String prompt) {
        MessageCreateParams params = MessageCreateParams.builder()
                .model(Model.CLAUDE_3_7_SONNET_LATEST)
                .addUserMessage(prompt)
                .build();
        Message message = client.messages().create(params);
        return message.getContent();
    }
}
