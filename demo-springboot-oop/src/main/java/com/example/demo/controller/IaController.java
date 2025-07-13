package com.example.demo.controller;

import com.example.demo.ia.AnthropicClientService;
import com.example.demo.service.SentimentService;
import lombok.RequiredArgsConstructor;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final AnthropicClientService anthropicClientService;
    private final SentimentService sentimentService;

    @GetMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(@RequestParam String prompt) {
        try {
            String respuesta = anthropicClientService.chat(prompt);
            return ResponseEntity.ok(Map.of("response", respuesta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Could not contact Anthropic: " + e.getMessage()));
        }
    }

    @GetMapping("/sentiment")
    public String sentiment(@RequestParam String text) {
        return sentimentService.analyze(text);
    }
}
