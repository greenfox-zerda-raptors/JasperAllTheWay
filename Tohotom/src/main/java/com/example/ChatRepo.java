package com.example;

import java.util.List;

/**
 * Created by Zoltán on 2017.01.26..
 */
public interface ChatRepo {

    List<ChatMessage> getMessages();

    void addMessage(ChatMessage message);
}
