package com.ktds.finalproject.plannerbe.domain.chatbot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
public class ChatController {

    private final String openApiUrl = "https://api.openai.com/v1/completions";
    private final String model = "gpt-3.5-turbo-instruct";
    private final String openApiToken = "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";


    @PostMapping("/api/chat")
    public ChatResponse chat(@RequestBody ChatMessage message) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openApiToken);
        headers.add("Content-Type", "application/json");

        String requestBody = "{\"model\": \"" + model + "\", \"prompt\": \"" + message.getMessage() + "\", \"max_tokens\": 1000, \"temperature\": 0.1}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                openApiUrl,
                HttpMethod.POST,
                entity,
                String.class);

        String responseJson = response.getBody();
        System.out.println(response);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(responseJson);
            String text = rootNode.path("choices").get(0).path("text").asText();
            return new ChatResponse(text);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ChatResponse("Sorry, I don't understand.");
    }

    static class ChatMessage {
        private String message;

        // getters and setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    static class ChatResponse {
        private String response;

        public ChatResponse(String response) {
            this.response = response;
        }

        // getters and setters
        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }


    }
}
