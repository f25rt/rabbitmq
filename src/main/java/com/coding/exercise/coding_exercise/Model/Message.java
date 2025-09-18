package com.coding.exercise.coding_exercise.Model;

public class Message {
    private final String sourceChannelId;
    private final String payload;

    public Message(String sourceChannelId, String payload) {
        this.sourceChannelId = sourceChannelId;
        this.payload = payload;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sourceChannelId='" + sourceChannelId + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
