package com.example.demo.client;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

/**
 * Minimal OpenAI client wrapper used for demo purposes.
 */
@Component
public class OpenAiClient {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    public String chat(String prompt) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("missing API key");
        }
        try {
            OpenAiService service = new OpenAiService(apiKey, Duration.ofSeconds(30));
            ChatMessage message = new ChatMessage("user", prompt);
            ChatCompletionRequest request = ChatCompletionRequest.builder()
                    .model("gpt-3.5-turbo")
                    .messages(List.of(message))
                    .build();
            ChatCompletionResult result = service.createChatCompletion(request);
            return result.getChoices().get(0).getMessage().getContent();
        } catch (Exception e) {
            throw new RuntimeException("Could not contact OpenAI: " + e.getMessage(), e);
        }
    }
}
