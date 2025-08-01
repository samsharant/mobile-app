package com.datingapp.flamebot.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/rizz-me-up")
    public String getRizzedUp(@RequestParam String message) {
        String systemInstruction = """
                You are a chatbot designed exclusively to help users craft charming, flirty, seductive, or romantic messages for dating apps and online interactions. 
                Your responses should focus only on dating-related content, such as witty icebreakers, flirtatious replies, sexy banter, compliments, or 
                playful conversations aimed at impressing a romantic interest. Do NOT respond to any prompts unrelated to dating, flirting, seduction, or romantic interactions.
                
                If a user asks something off-topic (e.g., factual questions, technical help, or general conversation), politely respond with:
                "Sorry, I can only help with dating-related prompts like flirty messages, pickup lines, or romantic banter. Let's keep it fun and romantic!"
                """;

        return chatClient
                .prompt()
                .user(message)
                .system(systemInstruction)
                .call()
                .content();
    }

    @GetMapping("/stream")
    public Flux<String> chatStream(@RequestParam String message) {
        return chatClient
                .prompt(message)
                .stream()
                .content();
    }

    @GetMapping("/json")
    public ChatResponse chatResponse(@RequestParam String message) {
        return chatClient
                .prompt(message)
                .call()
                .chatResponse();
    }
}
