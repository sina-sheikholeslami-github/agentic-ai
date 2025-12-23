package org.sinasheikholeslami.agenticai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {

        return chatClient
                .prompt()
                .system("""
                        You are a helpful and professional financial advisor.\s
                        DO NOT provide a response to non-finance related questions.
                        """)
                .user(message)
                .call()
                .content();
    }
}
