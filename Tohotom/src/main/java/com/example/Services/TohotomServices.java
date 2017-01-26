package com.example.Services;

import com.example.Domains.ChatMessage;
import com.example.Domains.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zoltán on 2017.01.26..
 */

@Component
public class TohotomServices{

    ChatMemoryRepo chatMemoryRepo;

    private String[] locations = new String[]{
      "budapest", "paris", "london", "tokyo", "new york"
    };
    private String[] punctuation = new String[]{
            "!", "?", "."
    };
    private String[] questionWord = new String[]{
            "what", "where", "who", "how"
    };
    private String[] keyWord = new String[]{
            "weather"
    };
    private String[] swearWord = new String[]{
      "fuck"
    };

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
        Conversation conversation = new Conversation();

        if(hasLocation(message.toLowerCase())){
            conversation.setLocation(obtainLocation(message));
        }
        if(hasPunctuation(message)){
            conversation.setSentenceType(obtainPunctuatuion(message));
        }
        if(startsWithQuestionWord(message.toLowerCase())){
            conversation.setQuestionWord(obtainQuestionWord(message));
        }
        if(hasKeyWord(message.toLowerCase())){
            conversation.setKeyWord(obtainKeyWord(message));
        }



            return calculateValidAnswerType(conversation);
    }




    private String calculateValidAnswerType(Conversation conversation) {
        String result = "";

        if(conversation.everythingIsNull()){
            return "not known type";
        }else if(conversation.getKeyWord() != null && conversation.getQuestionWord() != null){
            return "question about " + conversation.getKeyWord();
        } else if(conversation.getSwearWord() != null) {
            return "angy";
        }else {
            result += "Something about ";
            if (conversation.getLocation() != null) {
                result += "Location:" + conversation.getLocation();
            }
        }

        return result;
    }
    private boolean hasKeyWord(String message) {
        int h = 0;
        for(int i = 0; i < keyWord.length; i++){
            if(message.contains(keyWord[i])){
                h++;
            }
        }
        return h > 0;
    }

    private String obtainKeyWord(String message) {
        String result = null;
        for(int i = 0; i < keyWord.length; i++){
            if(message.contains(keyWord[i])){
                result = keyWord[i];
            }
        }
        return result;
    }

    private String obtainQuestionWord(String message) {
        String result = null;
        for(int i = 0; i < questionWord.length; i++){
            if(message.contains(questionWord[i])){
                result = questionWord[i];
            }
        }
        return result;
    }

    private String obtainPunctuatuion(String message) {
        String result = null;
        for(int i = 0; i < punctuation.length; i++){
            if(message.contains(punctuation[i])){
                result = punctuation[i];
            }
        }
        return result;
    }

    private String obtainLocation(String message) {
       String result = null;
        for(int i = 0; i<locations.length; i++){
            if(message.contains(locations[i])){
                result =  locations[i];
            }
            }
        return result;
    }

    private boolean startsWithQuestionWord(String message) {
        int h =0;
        for(int i = 0; i< questionWord.length; i++) {
            if (message.startsWith(questionWord[i])) {
                h++;
            }
        }
        return h>0;
    }

    private boolean hasPunctuation(String message) {
        int h = 0;
        for(int i = 0; i < punctuation.length; i++){
            h++;
        }
        return h>0;
    }

    private boolean hasLocation(String message) {
        int h = 0;
        for(int i = 0; i < locations.length; i++){
            if(message.contains(locations[i])){
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
