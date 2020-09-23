package pl.mzuchnik.communicatorserver.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import pl.mzuchnik.communicatorserver.model.ActiveUsers;
import pl.mzuchnik.communicatorserver.model.ChatMessage;

import javax.servlet.http.HttpSession;

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
                               SimpMessageHeaderAccessor headerAccessor){
        String username = chatMessage.getSender();
        activeUsers.addUser(username);

        return chatMessage;
    }


}
