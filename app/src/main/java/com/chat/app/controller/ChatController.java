package com.chat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    @MessageMapping("/sendMessage/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, ChatMessage message) {
        message.setRoomId(roomId);
        messagingTemplate.convertAndSend("/topic/messages/" + roomId, message);
    }
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/chat")
    public String chat() {
        return "chat"; // Return the name of the chat page template
    }
}
