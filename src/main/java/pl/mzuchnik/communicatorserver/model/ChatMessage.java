package pl.mzuchnik.communicatorserver.model;

public class ChatMessage{

    private MessageType type;
    private String content;
    private String sender;
    private String[] activeUsers;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        USERS_UPDATE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String[] getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(String[] activeUsers) {
        this.activeUsers = activeUsers;
    }
}
