package com.greenfox.jasper;

import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by almasics on 2017.01.20..
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Autowired
    private BuildingServices buildingServices;

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
                .initial(States.SI)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.SI).target(States.S1).event(Events.E1).action(actionFromBasicToOne(buildingServices))
                .and()
                .withExternal()
                .source(States.S1).target(States.S2).event(Events.E2).action(actionFromOneToTwo());
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
    public Action<States, Events> actionFromBasicToOne(BuildingServices buildingServices) {
        return context -> {
            this.buildingServices = buildingServices;
            buildingServices.saveBuilding(new Building());
            Building tempBuilding = buildingServices.findBuilding(1L);
            tempBuilding.setBuildingLevel(3);
            System.out.println(tempBuilding.buildingTosTring());
            buildingServices.saveBuilding(tempBuilding);
        };
    }

    @Bean
    public Action<States, Events> actionFromOneToTwo() {
        return context -> System.out.println("another action has been performed");
    }

    @Bean
    public Action<States, Events> actionFromTwoToBasic() {
        return context -> System.out.println("reverting to initial state");
    }

    @Bean
    public TimerAction timerAction() {
        return new TimerAction();
    }


}
