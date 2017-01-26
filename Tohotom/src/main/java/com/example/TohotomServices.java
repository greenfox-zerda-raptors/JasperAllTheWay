package com.example;

import org.springframework.stereotype.Component;

/**
 * Created by Zoltán on 2017.01.26..
 */

@Component
public class TohotomServices{

    ChatMemoryRepo chatMemoryRepo;

    public TohotomServices(ChatMemoryRepo chatMemoryRepo){
        this.chatMemoryRepo = chatMemoryRepo;
    }

    public void answerToLastMessage(){
        int i = chatMemoryRepo.getMessages().size();
        if(i > 0) {
//            TODO: This will do the Tohotom stuff
            chatMemoryRepo.getMessages().get(i - 1);
        }
        chatMemoryRepo.addDiscreteMessage(new ChatMessage("Tohotom", "Ok"));
    }
}
