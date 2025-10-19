package com.example.ollama.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    public enum Role { SYSTEM, USER, ASSISTANT }

    private final Role role;
    private final String content;
    private final LocalDateTime time;

    public Message(Role role, String content) {
        this.role = role;
        this.content = content == null ? "" : content;
        this.time = LocalDateTime.now();
    }

    public Role getRole() { return role; }
    public String getContent() { return content; }
    public String getTimeFormatted() {
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
