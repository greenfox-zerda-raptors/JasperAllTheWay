package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * Created by almasics on 2017.01.26..
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.Normal)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.Normal).target(States.Extroversion).event(Events.E1).action(actionFromBasicToExtrovert())
                .and()
                .withExternal()
                .source(States.Normal).target(States.Neuroticism).event(Events.E2).action(actionFromBasicToExtrovert())
                .and()
                .withExternal()
                .source(States.Normal).target(States.Agreeableness).event(Events.E3).action(actionFromBasicToExtrovert())
                .and()
                .withExternal()
                .source(States.Normal).target(States.Conscientious).event(Events.E4).action(actionFromBasicToExtrovert())
                .and()
                .withExternal()
                .source(States.Normal).target(States.Openness).event(Events.E5).action(actionFromBasicToExtrovert());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Bean
    public Action<States, Events> actionFromBasicToExtrovert() {
        return context -> {
        };
    }

    @Bean
    public Action<States, Events> actionFromBasicToNeurotic() {
        return context -> System.out.println("another action has been performed");
    }

    @Bean
    public Action<States, Events> actionFromBasicToAgreeable() {
        return context -> System.out.println("reverting to initial state");
    }

    @Bean
    public Action<States, Events> actionFromBasicToConscientious() {
        return context -> System.out.println("reverting to initial state");
    }

    @Bean
    public Action<States, Events> actionFromBasicToOpen() {
        return context -> System.out.println("reverting to initial state");
    }
}
