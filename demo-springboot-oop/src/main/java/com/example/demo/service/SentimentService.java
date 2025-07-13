package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Dummy sentiment analysis service.
 */
@Service
public class SentimentService {

    public String analyze(String text) {
        // Always return POSITIVE for demo
        return "POSITIVE";
    }
}
