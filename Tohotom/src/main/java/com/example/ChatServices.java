package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by Zoltán on 2017.01.26..
 */

@Component
public class ChatServices {

    ChatMemoryRepo chatMemoryRepo;

    @Autowired
    public ChatServices(ChatMemoryRepo chatMemoryRepo){
        this.chatMemoryRepo = chatMemoryRepo;
    }


    public List<ChatMessage> getMessages() {
        return chatMemoryRepo.getMessages();
    }


    public void addMessage(Model model) {
        model.addAttribute("chatMessage", new ChatMessage());
    }

    public void submitMessage(ChatMessage chatMessage, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("error");
        }else {
            chatMemoryRepo.addMessage(chatMessage);
        }
    }
}
