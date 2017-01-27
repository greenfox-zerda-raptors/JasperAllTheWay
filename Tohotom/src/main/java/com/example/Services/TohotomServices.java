package com.example.Services;

import com.example.Domains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zoltán on 2017.01.26..
 */

@Component
public class TohotomServices{

    ChatMemoryRepo chatMemoryRepo;

    private Personality personality;

    private TriggerWords triggerWords = new TriggerWords();

    private RandomAnswer randomAnswers = new RandomAnswer();

    @Autowired
    public TohotomServices(ChatMemoryRepo chatMemoryRepo){
        this.chatMemoryRepo = chatMemoryRepo;
    }

    public void answerToLastMessage(){
        int i = getChatRepoSize();
        if(i > 0) {
            String tohotomMessage = tohotomBrain(getLastMessage());
            chatMemoryRepo.addDiscreteMessage(new ChatMessage("Tohotom", tohotomMessage));
        }
    }


    private String tohotomBrain(String message) {
        // it hurts to see this.... sorry... RIP cleanCode....
        if(hasTriggerWords(message.toLowerCase())) {
            return randomAnswers.personalityAnswer(personality);
        }
        else{
            return "ok";
        }
    }

    private boolean hasTriggerWords(String message) {
        // TODO csaba's statemachine connection
        int h = 0;
        for(int i = 0; i < triggerWords.getExtraversion().size(); i++){
            if(message.contains(triggerWords.getExtraversion().get(i))){
                this.personality = Personality.EXTRAVERSION;
                h++;
            }
        }
        for(int i = 0; i < triggerWords.getAgreeableness().size(); i++){
            if(message.contains(triggerWords.getAgreeableness().get(i))){
                this.personality = Personality.AGREEABLENESS;
                h++;
            }
        }

        for(int i = 0; i < triggerWords.getNeurocitism().size(); i++){
            if(message.contains(triggerWords.getNeurocitism().get(i))){
                this.personality = Personality.NEUROTICISM;
                 h++;
            }
        }

        for(int i = 0; i < triggerWords.getOpennes().size(); i++){
            if(message.contains(triggerWords.getOpennes().get(i))){
                this.personality = Personality.OPENNES;
                 h++;
            }
        }

        for(int i = 0; i < triggerWords.getConscientiousness().size(); i++){
            if(message.contains(triggerWords.getConscientiousness().get(i))){
                this.personality = Personality.CONSCIENTIOUSNESS;
                h++;
            }
        }

        return h > 0;

    }

    private int getChatRepoSize() {
        return chatMemoryRepo.getMessages().size();
    }
    private String getLastMessage() {
        int i = getChatRepoSize();
        return chatMemoryRepo.getMessages().get(i -1).getMessage();
    }
}
