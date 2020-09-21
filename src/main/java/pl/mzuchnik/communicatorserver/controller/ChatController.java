package pl.mzuchnik.communicatorserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;
import pl.mzuchnik.communicatorserver.model.ActiveUsers;
import pl.mzuchnik.communicatorserver.model.ChatMessage;

@RestController
public class ChatController {

    private ActiveUsers activeUsers;

    public ChatController(ActiveUsers activeUsers) {
        this.activeUsers = activeUsers;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;
    }


    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) throws JsonProcessingException {
        String username = chatMessage.getSender();
        headerAccessor.getSessionAttributes().put("username", username);
        activeUsers.addUser(username);
        return chatMessage;
    }
}
