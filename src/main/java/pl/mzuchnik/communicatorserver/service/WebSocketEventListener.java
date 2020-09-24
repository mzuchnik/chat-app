package pl.mzuchnik.communicatorserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import pl.mzuchnik.communicatorserver.model.ActiveUsers;
import pl.mzuchnik.communicatorserver.model.ChatMessage;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    private SimpMessageSendingOperations messagingTemplate;

    private ActiveUsers activeUsers;

    @Autowired
    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate, ActiveUsers activeUsers) {
        this.messagingTemplate = messagingTemplate;
        this.activeUsers = activeUsers;
    }

    @EventListener(SessionConnectedEvent.class)
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener(SessionDisconnectEvent.class)
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = headerAccessor.getUser().getName();
        if (activeUsers.getUsers().contains(username)) {
            logger.info("User Disconnected : " + username);
            activeUsers.removeUser(username);
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}

