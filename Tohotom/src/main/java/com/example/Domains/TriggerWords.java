package com.example.Domains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zoltán on 2017.01.27..
 */


public class TriggerWords {
    private List<String> extraversion = new ArrayList<>(
            Arrays.asList(
                    "friend", "family", "mother", "father", "sister", "brother", "talk"
            ));

    private List<String> opennes = new ArrayList<>(
            Arrays.asList(
                    "artistic", "draw", "paint", "play", "music", "poem", "dance",
                    "sexual", "sex", "partner", "romantic", "gay", "lesbian",
                    "adventure", "try", "enjoy", "exciting", "new"
            ));

    private List<String> neurocitism = new ArrayList<>(
            Arrays.asList(
                    "feeling" ,"sad", "angry", "disappointed",
                    "anxiety", "afraid", "worry", "stressed"
            ));

    private List<String> agreeableness = new ArrayList<>(
            Arrays.asList(
                    "sympathy", "love", "like", "opinion", "think", "believe"
            ));

    private List<String> conscientiousness = new ArrayList<>(
            Arrays.asList(
                   "work", "deadline", "job", "boss", "colleague", "school",
                    "achievement", "prize", "purpose", "complete",
                    "order", "monday", "wednesday", "tuesday", "thursday", "friday", "saturday", "sunday", "routine"
            ));

    public TriggerWords() {
    }

    public List<String> getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(List<String> extraversion) {
        this.extraversion = extraversion;
    }

    public List<String> getOpennes() {
        return opennes;
    }

    public void setOpennes(List<String> opennes) {
        this.opennes = opennes;
    }

    public List<String> getNeurocitism() {
        return neurocitism;
    }

    public void setNeurocitism(List<String> neurocitism) {
        this.neurocitism = neurocitism;
    }

    public List<String> getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(List<String> agreeableness) {
        this.agreeableness = agreeableness;
    }

    public List<String> getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(List<String> conscientiousness) {
        this.conscientiousness = conscientiousness;
    }
}
