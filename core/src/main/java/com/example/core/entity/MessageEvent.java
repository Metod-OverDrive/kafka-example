package com.example.core.entity;

import java.time.LocalDateTime;

public class MessageEvent {

    private String messageId;
    private String title;
    private String message;
    private LocalDateTime time;

    public MessageEvent() {
    }

    public MessageEvent(String messageId, String title, String message, LocalDateTime time) {
        this.messageId = messageId;
        this.title = title;
        this.message = message;
        this.time = time;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "messageId='" + messageId + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
