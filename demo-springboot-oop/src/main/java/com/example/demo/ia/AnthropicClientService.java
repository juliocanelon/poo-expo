package com.example.demo.ia;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AnthropicClientService {

    @Value("${ANTHROPIC_API_KEY}")
    private String apiKey;

    public String chat(String prompt) {
        AnthropicClient client = AnthropicOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
        MessageCreateParams params = MessageCreateParams.builder()
                .addUserMessage(prompt)
                .model(Model.CLAUDE_3_7_SONNET_LATEST)
                .build();
        Message message = client.messages().create(params);
        return message.getContent();
    }
}
