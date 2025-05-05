package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.app.model.ChatMessage;

/**
 * Handles incoming chat messages in the front end and broadcasts them to all connected clients.
 */
@Controller
public class ChatController {
    //broadcasts the message to all connected clients
    // the message will be sent to the /topic/messages endpoint
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat"; // Return the name of the chat page template
    }
}
