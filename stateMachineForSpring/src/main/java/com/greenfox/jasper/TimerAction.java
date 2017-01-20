package com.greenfox.jasper;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * Created by almasics on 2017.01.20..
 */
public class TimerAction implements Action<String, String> {

    @Override
    public void execute(StateContext<String, String> context) {
        System.out.println("print something every second");
    }
}
