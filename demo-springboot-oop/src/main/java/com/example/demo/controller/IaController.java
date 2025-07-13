package com.example.demo.controller;

import com.example.demo.service.OpenAiClient;
import com.example.demo.service.SentimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing simple IA endpoints.
 */
@RestController
@RequestMapping("/api/ia")
@RequiredArgsConstructor
public class IaController {

    private final OpenAiClient openAiClient;
    private final SentimentService sentimentService;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        return openAiClient.chat(prompt);
    }

    @GetMapping("/sentiment")
    public String sentiment(@RequestParam String text) {
        return sentimentService.analyze(text);
    }
}
