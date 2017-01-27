package com.example.Domains;

import java.util.*;


/**
 * Created by Zoltán on 2017.01.27..
 */
public class RandomAnswer {

    private Personality personality;
    private static Random rnd = new Random();
    private List<String> weather = new ArrayList<>(
            Arrays.asList("sunny", "rainy", "cloudy", "good", "terrific"));

    private List<String> extraversion = new ArrayList<>(
            Arrays.asList(
                    "Friendship is the most important thing in the world.",
                    "This can be the beginning of a beautiful friendship.",
                    "You know, my mother always told me that water is sweet but blood is thicker",
                    "Having a nice family is amazing!",
                    "Every family has some crazy stuff but I think this is normal.",
                    "Sometimes I just talk and talk and talk and can’t stop, but it makes me really happy when someone listens to me",
                    "Every conflict can be solved with a nice loong conversation, don’t you think?",
                    "It is amazing to have someone you can freely talk to!"
            ));

    private List<String> agreeableness = new ArrayList<>(
            Arrays.asList(
                    "You musn’t be ashamed of your feelings.",
                    "I get it, you have every right to like anything you want.",
                    "Don’t worry, feeling this way is completely okay",
                    "I agree with you",
                    "Everyone has their right to have an opinion",
                    "I'm sure you have your reasons to think like this.",
                    "And why do you believe it?"
            ));

    private List<String> conscientiousness = new ArrayList<>(
            Arrays.asList(
                    "If you don’t work hard, don’t expect to solve your problems",
                    "You don’t get fired without any reason, so think about your actions!",
                    "You should pay attention to your deadlines",
                    "Without a purpose, a man’s life worths nothing",
                    "Complete your tasks before doint anything else: this is my recipe of a calm mind",
                    "It is important to know one’s own limits",
                    "Time is money, boy!",
                    "You are determined to be late, aren’t you?",
                    "Early bird gets the worm, you know?"
            ));

    private List<String> neuroticism = new ArrayList<>(
            Arrays.asList(
                    "The whole world is sad and hopeless...",
                    "I think you are depressed.",
                    "I just want to cry",
                    "I am just waiting for something good to happen, but it seems like it never comes",
                    "This is so stupid, why can’t anything work??",
                    "Human life is so stressful, we should just stop it somehow",
                    "It feels like everything is against us!",
                    "It is just horrible, horrible!"
            ));

    private List<String> opennes = new ArrayList<>(
            Arrays.asList(
                    "Art is the soul of humanity",
                    "If you don’t like music, you are not even human",
                    "How can you live without arts? My answer is: you can’t.",
                    "Don’t say you don’t like it without trying it",
                    "You need to be open toward new experiences",
                    "Every form of sexuality is acceptable!",
                    "Life is boring without new things...",
                    "Why do you even live if you don’t do exciting things?",
                    "Yes, go on an adventure! It helps develop your personality."
            ));


    public RandomAnswer() {
    }

    public String personalityAnswer(Personality personality){
       List<String > resultList;
        switch (personality){
            case EXTRAVERSION:
                resultList = extraversion;
                break;
            case OPENNES:
                resultList = opennes;
                break;
            case NEUROTICISM:
                resultList = neuroticism;
                break;
            case CONSCIENTIOUSNESS:
                resultList = conscientiousness;
                break;
            case AGREEABLENESS:
                resultList = agreeableness;
                break;
            default:
                resultList = null;
        }

        return resultList.get(rnd.nextInt(resultList.size()-1));
    }

    public String getRandomWeather() {
        return weather.get(rnd.nextInt(weather.size()-1));
    }


    public List<String> getWeather() {
        return weather;
    }

    public void setWeather(List<String> weather) {
        this.weather = weather;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public static Random getRnd() {
        return rnd;
    }

    public static void setRnd(Random rnd) {
        RandomAnswer.rnd = rnd;
    }

    public List<String> getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(List<String> extraversion) {
        this.extraversion = extraversion;
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

    public List<String> getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(List<String> neuroticism) {
        this.neuroticism = neuroticism;
    }

    public List<String> getOpennes() {
        return opennes;
    }

    public void setOpennes(List<String> opennes) {
        this.opennes = opennes;
    }
}
