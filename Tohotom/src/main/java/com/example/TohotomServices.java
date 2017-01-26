package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zoltán on 2017.01.26..
 */

@Component
public class TohotomServices{

    ChatMemoryRepo chatMemoryRepo;

    @Autowired
    public TohotomServices(ChatMemoryRepo chatMemoryRepo){
        this.chatMemoryRepo = chatMemoryRepo;
    }

    public void answerToLastMessage(){
        int i = getChatRepoSize();
        if(i > 0) {
//            TODO: This will do the Tohotom stuff
            String tohotomMessage = brains(getLastMessage());
            chatMemoryRepo.addDiscreteMessage(new ChatMessage("Tohotom", tohotomMessage));
        }

    }

    private String brains(String message) {
        return "ok";
    }











    private int getChatRepoSize() {
        return chatMemoryRepo.getMessages().size();
    }
    private String getLastMessage() {
        int i = getChatRepoSize();
        return chatMemoryRepo.getMessages().get(i -1).getMessage();
    }
}
