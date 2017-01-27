package com.example.Services;

import com.example.Domains.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoltán on 2017.01.26..
 */
@Repository
public class ChatMemoryRepo implements ChatRepo {

    private  List<ChatMessage> chatMessages = new ArrayList<>();

    @Override
    public List<ChatMessage> getMessages() {
        return chatMessages;
    }

    @Override
    public void addMessage(ChatMessage message) {
        chatMessages.add(message);
    }

    public void addDiscreteMessage(ChatMessage chatMessage) {
        chatMessages.add(chatMessage);
    }

    public void deleteAll() {
        this.chatMessages = new ArrayList<>();
    }
}
