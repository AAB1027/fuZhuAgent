
package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LlmService {

    public String call(String prompt) {
        // mock response (replace with real API)
        return "[LLM RESPONSE] " + prompt;
    }
}
