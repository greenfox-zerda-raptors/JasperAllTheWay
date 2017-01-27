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

    private String topic;

    private Personality personality;

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
        Conversation conversation = new Conversation();

        // it hurts to see this.... sorry... RIP cleanCode....
        if(hasTriggerWords(message.toLowerCase())){
                return randomAnswers.personalityAnswer(personality);
        }else {
            if (hasLocation(message.toLowerCase())) {
                conversation.setLocation(obtainLocation(message));
            }
            if (hasPunctuation(message)) {
                conversation.setSentenceType(obtainPunctuatuion(message));
            }
            if (startsWithQuestionWord(message.toLowerCase())) {
                conversation.setQuestionWord(obtainQuestionWord(message));
            }
            if (hasKeyWord(message.toLowerCase())) {
                conversation.setKeyWord(obtainKeyWord(message));
            }
            return calculateValidAnswerType(conversation);
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


    private String calculateValidAnswerType(Conversation conversation) {
        String result = "";

         if(conversation.everythingIsNull()) {
            return "I could not get that!";
        } else if(conversation.oneThingIsNotNull() && topic != null) {
            return createAnswerWithKeyWord(conversation, topic);

        }else if(conversation.getKeyWord() != null && conversation.getQuestionWord() != null){
            return createAnswerWithKeyWord(conversation, conversation.getKeyWord());
        } else if(conversation.getSwearWord() != null) {
//            prob not necessary anymore
            return "angry";
        }
        return result;
    }

    private String createAnswerWithKeyWord(Conversation conversation, String keyWord) {
        if(keyWord.contains("weather")){
            this.topic = "weather";
            if(conversation.getLocation() != null){
                this.topic = null;
                return "The weather in " + conversation.getLocation() +  " is " + randomAnswers.getRandomWeather();
            }else if (conversation.getLocation() == null){
                return "Where?";
            }else{
                return "ok";
            }
        }else{
            return "OK";
        }
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
            if(message.toLowerCase().contains(locations[i])){
                result =  locations[i];
            }
        }
        return result;
    }

    private boolean startsWithQuestionWord(String message) {
        int h =0;
        for(int i = 0; i< questionWord.length; i++) {
            if (message.contains(questionWord[i])) {
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
