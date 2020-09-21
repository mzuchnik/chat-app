package pl.mzuchnik.communicatorserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import pl.mzuchnik.communicatorserver.model.ActiveUsers;
import pl.mzuchnik.communicatorserver.model.ChatMessage;

@Component
public class UserMessageUpdater implements MessageUpdater {

    private SimpMessageSendingOperations messagingTemplate;
    private ActiveUsers activeUsers;

    @Autowired
    public UserMessageUpdater(SimpMessageSendingOperations messagingTemplate, ActiveUsers activeUsers) {
        this.messagingTemplate = messagingTemplate;
        this.activeUsers = activeUsers;
    }

    @Override
    public void update() {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.USERS_UPDATE);
        chatMessage.setActiveUsers(activeUsers.getUsers().toArray(new String[activeUsers.size()]));
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }


}
