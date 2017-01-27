package com.example.Domains;

/**
 * Created by Zoltán on 2017.01.26..
 */
public class Conversation {


    String topic = null;
    String keyWord = null;
    String conversationState = null;
    String location = null;
    String sentenceType = null;
    String questionWord = null;
    String swearWord = null;


    public Conversation() {
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConversationState() {
        return conversationState;
    }

    public void setConversationState(String conversationState) {
        this.conversationState = conversationState;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(String sentenceType) {
        this.sentenceType = sentenceType;
    }

    public String getQuestionWord() {
        return questionWord;
    }

    public void setQuestionWord(String questionWord) {
        this.questionWord = questionWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getSwearWord() {
        return swearWord;
    }

    public void setSwearWord(String swearWord) {
        this.swearWord = swearWord;
    }

    public boolean everythingIsNull(){
        return (topic == null &&
                location == null &&
                conversationState == null &&
                sentenceType == null &&
                questionWord == null &&
                keyWord == null  &&
                swearWord == null
        );
    }

    public boolean oneThingIsNotNull() {
        int k = 0;
                if(topic == null){
                    k++;
                }
                if(location == null){
                    k++;
                }
                if(conversationState == null){
                    k++;
                }
                if(sentenceType == null){
                    k++;
                }
                if(questionWord == null){
                    k++;
                }
                if(keyWord == null){
                    k++;
                }
                if(swearWord == null){
                    k++;
                }
        return k == 6;
    }
}
