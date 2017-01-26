package com.example.Domains;

/**
 * Created by Zoltán on 2017.01.26..
 */

public class ChatMessage {

    private String sender = "You";
    private String message;
    private long time = 1;


    public ChatMessage() {
    }

    public ChatMessage(String message){
        this.message = message;
        this.sender = "You";
    }

    public ChatMessage(String msgSender, String message) {
        this.sender = msgSender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
